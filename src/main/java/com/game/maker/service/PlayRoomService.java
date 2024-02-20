package com.game.maker.service;

import com.game.maker.builder.QuestionMapper;
import com.game.maker.dto.*;
import com.game.maker.exception.UserNotFoundException;
import com.game.maker.model.Alternative;
import com.game.maker.model.PlayerGameplaySession;
import com.game.maker.model.PlayerQuestionSession;
import com.game.maker.model.Question;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlayRoomService {

  private final Logger LOGGER = LogManager.getLogger(PlayRoomService.class);
  private final UserService userService;
  private final QuestionService questionService;
  private final PlayerGameplaySessionService playerGameplaySessionService;
  private final QuestionMapper questionMapper;
  private final QuestionSessionService questionSessionService;
  private final GameConfigurationService gameConfigurationService;


  public StartGameResponse createSessionAndGeneratedQuestions(Long userId, String theme, String level) {
    List<QuestionDTO> questionDTOList = null;
    List<PlayerGameplaySessionDTO> playerGameplaySessionDTOList = getActiveGameplaySessionByUserIdAndLevel(userId, level);
    StartGameResponse startGameResponse = new StartGameResponse();
    try {
      if(existActiveUserSessionInDataBase(playerGameplaySessionDTOList)) {
        startGameResponse.setGameplaySessionId(playerGameplaySessionDTOList.getFirst().getId());
        startGameResponse.setResponseMessage("Existe uma sessão carregada para o usuário, você precisa primeoro terminar a sessão atual para começar outra.");
        LOGGER.warn("Já existe uma sessão carregada para userId [{}]", userId);
      } else {
        startGameResponse.setResponseMessage("Bem vindo ao jogo quiz! As perguntas para o seu tema e level foram carregadas com sucesso!");
        Long playerGameplaySessionId = createPlayerSessionWithQuestionsByTheme(level, theme, userId);
        startGameResponse.setGameplaySessionId(playerGameplaySessionId);
        LOGGER.debug("A gameplay foi criada com sucesso! playerGameplaySessionId: [{}]", playerGameplaySessionId);
      }
    } catch(Exception ex) {
      LOGGER.error("Ocorreu um erro em generatedSessionForPlayer: ", ex);
    }
    return startGameResponse;
  }

  private boolean isActiveSession(PlayerGameplaySessionDTO playerGameplaySessionDTO) {
    return Objects.nonNull(playerGameplaySessionDTO) && playerGameplaySessionDTO.getSessionActivated();
  }

  public InGameQuestionAndAlternativesDTO findRandomQuestionActiveInPlayerSession(Long userId, Long gameplaySessionId) {
    InGameQuestionAndAlternativesDTO inGameQuestionAndAlternativesDTO = new InGameQuestionAndAlternativesDTO();
    PlayerGameplaySessionDTO playerGameplaySessionDTO = findActiveSessionById(gameplaySessionId);
    Long unplayedQuestions = questionSessionService.countUnplayedQuestions(gameplaySessionId);

    inGameQuestionAndAlternativesDTO.setUnplayedQuestions(unplayedQuestions);
    LOGGER.debug("Quantidade de questões ainda não usadasa: [{}]", unplayedQuestions);

    PlayerQuestionSession playerQuestionSessionIntoDataBase = questionSessionService.findActiveUnansweredQuestionsInSession(gameplaySessionId, userId);

    if(isOpenSessionWithUnansweredQuestions(playerQuestionSessionIntoDataBase)) {
      LOGGER.debug("Foi encontrada uma sessão ativa na base de dados de id [{}] ", playerQuestionSessionIntoDataBase.getId());
      addValuesIntoInGameQuestionAndAlternativesDTO(playerQuestionSessionIntoDataBase, inGameQuestionAndAlternativesDTO);
      inGameQuestionAndAlternativesDTO.setUserMessage("Existe uma questão ativa na sua sessão, termine o jogo atual antes de solicitar uma nova questão!");
      return inGameQuestionAndAlternativesDTO;
    }

    if(isActiveSession(playerGameplaySessionDTO) && isAlternativePresentInUnrespondedSession(unplayedQuestions)) {
      try {
        PlayerQuestionSession playerQuestionSession = this.questionSessionService.getRandomNotUsedQuestion();
        playerQuestionSession.setQuestionIsActive(true);

        this.questionSessionService.save(playerQuestionSession);
        addValuesIntoInGameQuestionAndAlternativesDTO(playerQuestionSession, inGameQuestionAndAlternativesDTO);
        inGameQuestionAndAlternativesDTO.setUserMessage("Muito bem meu caro jogador responda a pergunta para continuar o jogo!");
      } catch(Exception ex) {
        LOGGER.error("Erro ao tentar buscar dados da questão na sessão. Erro: ", ex);
      }
      LOGGER.debug("A questão foi gerada pelo sistema, a questão encontrada foi: [{}]", inGameQuestionAndAlternativesDTO);
      return inGameQuestionAndAlternativesDTO;
    }
    LOGGER.info(sessionUserNotActiveMessage());
    inGameQuestionAndAlternativesDTO.setUserMessage(sessionUserNotActiveMessage());

    return inGameQuestionAndAlternativesDTO;
  }

  public InGameAlternativeResponse validatePLayerQuestionAlternative(Long userId, Long gameplaySessionId, String selectedAlternative) {
    PlayerQuestionSession currentPlayerQuestionSession = questionSessionService.findActiveUnansweredQuestionsInSession(gameplaySessionId, userId);
    InGameAlternativeResponse inGameAlternativeResponse = new InGameAlternativeResponse();
    List<Alternative> currentSessionAlternativeList = null;
    Long currentUnplayedQuestions = questionSessionService.countUnplayedQuestions(gameplaySessionId);

    if(isNotThereOpenSessionWithQuestionsToAnswer(currentPlayerQuestionSession)) {
      inGameAlternativeResponse.setPlayerMessage(sessionNotFoundMessage() + gameplaySessionId);
      inGameAlternativeResponse.setCurrentQuestionPosition(currentUnplayedQuestions);
      LOGGER.warn(sessionNotFoundMessage() + "[{}]", gameplaySessionId);
      return inGameAlternativeResponse;
    }
    currentSessionAlternativeList = currentPlayerQuestionSession.getQuestion().getAlternativeList();
    Optional<Alternative> correctSessionAlternative = getCorrectSessionAlternative(currentSessionAlternativeList);

    if(correctSessionAlternative.isPresent()) {
      if(isCorrectAlternative(correctSessionAlternative, selectedAlternative)) {
        Long currentScoreWinPerSessionLevel = getScoreConfigurationBySessionLevel(gameplaySessionId);
        inGameAlternativeResponse.setQuestionScore(currentScoreWinPerSessionLevel);
        currentPlayerQuestionSession.setPlayerWin(true);
        currentPlayerQuestionSession.setScore(currentScoreWinPerSessionLevel);

        updateScorePlayerIntoSession(gameplaySessionId, currentScoreWinPerSessionLevel);
        LOGGER.debug("O jogador venceu! E ganhou pontos na sua sessão! Alternativa selecionada: [{}]", selectedAlternative);
        inGameAlternativeResponse.setPlayerMessage("O jogador venceu! E ganhou pontos na sua sessão!");
      } else {
        inGameAlternativeResponse.setQuestionScore(0L);
        currentPlayerQuestionSession.setPlayerWin(false);
        LOGGER.debug("O jogador perdeu! E não recebeu pontos na sessão até o momento!");
        inGameAlternativeResponse.setPlayerMessage("O jogador perdeu! e não recebeu pontos na sessão até o momento!");
      }

      if(isTheLastAlternativeOfSession(currentUnplayedQuestions)) {
        setValuesToDisablePlayerSession(inGameAlternativeResponse, gameplaySessionId);
        inGameAlternativeResponse.setSessionOverMessage("Todas as alternativas já foram respondidas para essa sessão chegou ao fim!");
        inGameAlternativeResponse.setSessionOver(true);
        inGameAlternativeResponse.setCurrentQuestionPosition(currentUnplayedQuestions);
      }
      disableCurrentPlayerQuestion(currentPlayerQuestionSession);
      addInGameAlternativeResponseValues(inGameAlternativeResponse, correctSessionAlternative.get(), selectedAlternative, currentUnplayedQuestions, gameplaySessionId);
    } else {
      LOGGER.error("A base de dados está inconsistente e tem alternativas cadastradas com nenhuma alternativa correta! O que impede o jogador de jogar corrtamente! verifique na lista de alternativas: [{}]", currentSessionAlternativeList);
    }
    return inGameAlternativeResponse;
  }

  private void addInGameAlternativeResponseValues(InGameAlternativeResponse inGameAlternativeResponse, Alternative correctSessionAlternative, String selectedAlternative, Long currentUnplayedQuestions, Long sessionId) {
    inGameAlternativeResponse.setCorrectAlternative(correctSessionAlternative.getReferenceLetter() + " - " + correctSessionAlternative.getAlternative());
    inGameAlternativeResponse.setSelectedAlternative(selectedAlternative);
    inGameAlternativeResponse.setCurrentQuestionPosition(currentUnplayedQuestions);
    inGameAlternativeResponse.setCurrentSessionScore(questionSessionService.sumScoreForCurrentSessionUntilNow(sessionId));
    LOGGER.debug("ingame current score: [{}]", inGameAlternativeResponse.getCurrentSessionScore());
  }

  private void disableCurrentPlayerQuestion(PlayerQuestionSession currentPlayerQuestionSession) {
    currentPlayerQuestionSession.setQuestionIsActive(false);
    currentPlayerQuestionSession.setWasPlayed(true);
    this.questionSessionService.save(currentPlayerQuestionSession);
  }

  private Long createPlayerSessionWithQuestionsByTheme(String level, String theme, Long userId) {
    List<PlayerQuestionSession> playerQuestionSessionList = new ArrayList<>();

    PlayerGameplaySession playerGameplaySession = new PlayerGameplaySession();
    playerGameplaySession.setLevel(level);
    playerGameplaySession.setSessionActivated(true);
    playerGameplaySession.setScore(0L);
    playerGameplaySession.setUserId(userId);

    List<QuestionDTO> questionList = questionService.findByTheme(theme);

    for(QuestionDTO questionDTO : questionList) {
      Question enterRoomQuestion = questionMapper.toEntity(questionDTO);
      playerQuestionSessionList.add(new PlayerQuestionSession(enterRoomQuestion, playerGameplaySession, false));
    }
    playerGameplaySession.setPlayerGameplaySessionQuestions(playerQuestionSessionList);
    Long playerGameplaySessionId = playerGameplaySessionService.save(playerGameplaySession).getId();
    LOGGER.debug("playerGameplaySession foi salva na base de dados o valor salvo foi: [{}] ", playerGameplaySession);
    return playerGameplaySessionId;
  }

  private boolean existActiveUserSessionInDataBase(List<PlayerGameplaySessionDTO> playerGameplaySessionDTOList) {
    return (!playerGameplaySessionDTOList.isEmpty());
  }

  //TODO Ajustar para tirar o 'cascate' das chamadas que tem filho como lista, e ajustar os lugares que precisam disso para funcionar!
  //TODO Problema de apagar o filho quando não passa a lista, está resolvido mas fica muito pesado assim!
  private void updateScorePlayerIntoSession(Long gameplaySessionId, Long currentScoreWinPerSessionLevel) {
    PlayerGameplaySessionDTO playerGameplaySessionDTO = playerGameplaySessionService.findById(gameplaySessionId);
    playerGameplaySessionDTO.setScore(playerGameplaySessionDTO.getScore() + currentScoreWinPerSessionLevel);
    playerGameplaySessionService.save(playerGameplaySessionDTO);
  }

  private boolean isOpenSessionWithUnansweredQuestions(PlayerQuestionSession playerQuestionSessionIntoDataBase) {
    return Objects.nonNull(playerQuestionSessionIntoDataBase);
  }

  private boolean isNotThereOpenSessionWithQuestionsToAnswer(PlayerQuestionSession playerQuestionSessionIntoDataBase) {
    return Objects.isNull(playerQuestionSessionIntoDataBase);
  }

  private boolean isAllSessionAlternativesAnswered(Long unplayedQuestions) {
    return unplayedQuestions == 0;
  }

  private boolean isTheLastAlternativeOfSession(Long unplayedQuestions) {
    return unplayedQuestions == 1;
  }

  private boolean isAlternativePresentInUnrespondedSession(Long unplayedQuestions) {
    return (Objects.nonNull(unplayedQuestions) && unplayedQuestions > 0);
  }

  private void setValuesToDisablePlayerSession(InGameAlternativeResponse inGameAlternativeResponse, Long gameplaySessionId) {
    inGameAlternativeResponse.setSessionOver(true);
    inGameAlternativeResponse.setSessionOverMessage("A Sessão chegou ao seu fim!");
    disableGameplaySession(gameplaySessionId);
    LOGGER.debug("Chegou na ultima alternativa válida do sistema.");
  }

  private Long getScoreConfigurationBySessionLevel(Long gameplaySessionId) {
    Optional<PlayerGameplaySessionDTO> playerGameplaySessionDTO = playerGameplaySessionService.findBySessionActivatedAndId(true, gameplaySessionId);
    if(playerGameplaySessionDTO.isPresent()) {
      GameConfigurationDTO gameConfigurationDTO = gameConfigurationService.findByLevel(playerGameplaySessionDTO.get().getLevel());
      return gameConfigurationDTO.getScorePerHit();
    } else {
      return 0L;
    }
  }

  private void disableGameplaySession(Long gameplaySessionId) {
    PlayerGameplaySessionDTO playerGameplaySessionDTO = playerGameplaySessionService.findById(gameplaySessionId);
    playerGameplaySessionDTO.setSessionActivated(false);
    playerGameplaySessionService.save(playerGameplaySessionDTO);
  }

  private Optional<Alternative> getCorrectSessionAlternative(List<Alternative> currentSessionAlternativeList) {
    return currentSessionAlternativeList.stream()
        .filter(Alternative::getItsCorrect)
        .findFirst();
  }

  private boolean isCorrectAlternative(Optional<Alternative> correctSessionAlternative, String selectedAlternative) {
    LOGGER.debug("Foi encontrada uma alvernativa para a sessão, agora será validada se a alternativa condiz com a alternative selecionada que é [{}] ", selectedAlternative);
    return correctSessionAlternative.map(alternative -> alternative.getReferenceLetter().equals(selectedAlternative)).orElse(false);
  }

  private PlayerGameplaySessionDTO findActiveSessionById(Long playerGameplaySessionId) {
    Optional<PlayerGameplaySessionDTO> playerGameplaySessionDTO = playerGameplaySessionService.findBySessionActivatedAndId(true, playerGameplaySessionId);
    LOGGER.debug("Busca por sessão ativa terminada com sucesso! playerGameplaySessionValueDTO: [{}]", playerGameplaySessionDTO);
    return (playerGameplaySessionDTO.orElse(null));
  }

  private static void addValuesIntoInGameQuestionAndAlternativesDTO(PlayerQuestionSession playerQuestionSession, InGameQuestionAndAlternativesDTO inGameQuestionAndAlternativesDTO) {
    List<Alternative> alternativesListedIntoOneQuestionOfSession = playerQuestionSession.getQuestion().getAlternativeList();
    List<InGameAlternativeDTO> inGameAlternativeDTOList = new ArrayList<>();

    inGameQuestionAndAlternativesDTO.setQuestion(playerQuestionSession.getQuestion().getQuestion());
    inGameQuestionAndAlternativesDTO.setQuestionId(playerQuestionSession.getQuestion().getId());

    for(Alternative alternative : alternativesListedIntoOneQuestionOfSession) {
      InGameAlternativeDTO inGameAlternativeDTO = new InGameAlternativeDTO();
      inGameAlternativeDTO.setId(alternative.getId());
      inGameAlternativeDTO.setAlternative(alternative.getAlternative());
      inGameAlternativeDTO.setReferenceLetter(alternative.getReferenceLetter());
      inGameAlternativeDTOList.add(inGameAlternativeDTO);
    }
    inGameQuestionAndAlternativesDTO.setInGameAlternativeDTO(inGameAlternativeDTOList);
  }

  public List<PlayerGameplaySessionDTO> getActiveGameplaySessionByUserIdAndLevel(Long userId, String level) {
    return playerGameplaySessionService.findByActiveGameplaySessionByLevelAndUserId(level, userId);
  }

  private UserDTO findUserById(Long userId) {
    Optional<UserDTO> userDTO = Optional.ofNullable(userService.findUserById(userId));
    try {
      if(userDTO.isEmpty()) {
        throw new UserNotFoundException(userNotFoundMessage(userId));
      }
    } catch(UserNotFoundException ex) {
      LOGGER.error("Ocorreu um erro no método findUserById: Erro:", ex);
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, userNotFoundExternalMessage(), ex);
    } catch(Exception ex) {
      //Qualquer outra exception cai aqui!
      LOGGER.error("Ocorreu um erro no método findUserById: Erro:", ex);
    }
    return userDTO.orElse(null);
  }

  private String userNotFoundMessage(Long userId) {
    return "O usuário com id: " + userId + " não foi encontrado";
  }

  private String userNotFoundExternalMessage() {
    return "Ocorreu um erro ao tentar recuperar o usuário da sessão, retorno do erro: ";
  }

  private String userNotHaveActiveQuestionsMessage() {
    return "O id do usuário enviado não está dentro de nenhuma sala válida, crie uma sala com um id de usuário válido antes de iniciar um jogo.";
  }

  private String sessionNotFoundMessage() {
    return "A sessão solicitada pelo requisitante não existe, não foi encontrado id de sessão ativo válido para o valor informado id: ";
  }

  private String sessionUserNotActiveMessage() {
    return "A Sessão do usuário não está ativa, é necessário ter uma sessão ativa para continuar.";
  }

}