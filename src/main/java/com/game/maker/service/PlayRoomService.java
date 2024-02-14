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


    public InGameSessionDTO createSessionAndGeneratedQuestions(Long userId, String theme, String level) {
        List<QuestionDTO> questionDTOList = null;
        List<PlayerGameplaySessionDTO> playerGameplaySessionDTOList = getActiveGameplaySessionByUserIdAndLevel(userId, level);
        InGameSessionDTO inGameSessionDTO = new InGameSessionDTO();
        try {
            if (activeUserSessionInDataBase(playerGameplaySessionDTOList)) {
                inGameSessionDTO.setPlayerSessionQuestionId(playerGameplaySessionDTOList.getFirst().getId());
                inGameSessionDTO.setResponseMessage("Existe uma sessão carregada para o usuário, você precisa primeoro terminar a sessão atual para começar outra.");
                LOGGER.warn("Já existe uma sessão carregada para userId [{}]", userId);
            } else {
                inGameSessionDTO.setResponseMessage("Bem vindo ao jogo quiz! As perguntas para o seu tema e level foram carregadas com sucesso!");
                Long playerGameplaySessionId = createPlayerSessionWithQuestionsByTheme(level, theme, userId);
                inGameSessionDTO.setPlayerSessionQuestionId(playerGameplaySessionId);
            }
        } catch (Exception ex) {
            LOGGER.error("Ocorreu um erro em generatedSessionForPlayer: ", ex);
        }
        return inGameSessionDTO;
    }

    private Long createPlayerSessionWithQuestionsByTheme(String level, String theme, Long userId){
        List<PlayerQuestionSession> playerQuestionSessionList = new ArrayList<>();

        PlayerGameplaySession playerGameplaySession = new PlayerGameplaySession();
        playerGameplaySession.setLevel(level);
        playerGameplaySession.setSessionActivated(true);
        playerGameplaySession.setScore(0L);
        playerGameplaySession.setUserId(userId);

        List<QuestionDTO> questionList = questionService.findByTheme(theme);

        for (QuestionDTO questionDTO : questionList) {
            Question enterRoomQuestion = questionMapper.toEntity(questionDTO);
            playerQuestionSessionList.add(new PlayerQuestionSession(enterRoomQuestion, playerGameplaySession, false));
        }
        playerGameplaySession.setPlayerGameplaySessionQuestions(playerQuestionSessionList);
        Long playerGameplaySessionId = playerGameplaySessionService.save(playerGameplaySession).getId();
        LOGGER.info("playerGameplaySession foi salva na base de dados o valor salvo foi: [{}] ", playerGameplaySession);
        return playerGameplaySessionId;
    }

    private boolean activeUserSessionInDataBase(List<PlayerGameplaySessionDTO> playerGameplaySessionDTOList){
        return (!playerGameplaySessionDTOList.isEmpty()) ;
    }

    /**
     * Busca uma pergunta randomica dentro da sessão do usuário, lembrando que essa pergunta precisa estar com a coluna
     * isActivated como true se não ela já foi respondida e não será acessada na busca randomica.
     */
    public InGameQuestionAndAlternativesDTO findRandomQuestionActiveInPlayerSession(InGameSessionDTO inGameSessionDTO) {
        Long playerGameSessionRoomId = inGameSessionDTO.getPlayerSessionQuestionId();
        InGameQuestionAndAlternativesDTO inGameQuestionAndAlternativesDTO = new InGameQuestionAndAlternativesDTO();
        PlayerGameplaySessionDTO playerGameplaySessionDTO = getSession(playerGameSessionRoomId);

        Long unplayedQuestions = questionSessionService.countUnplayedQuestions(playerGameSessionRoomId);
        inGameQuestionAndAlternativesDTO.setUnplayedQuestions(unplayedQuestions);
        LOGGER.info("Quantidade de questões ainda não usadasa: [{}]", unplayedQuestions);

        LOGGER.info("Iniciando busca de questões ativas na sessão, a busca vai ser na base de dados, caso a sessão exista, não será criada outra! id da busca [{}]", playerGameSessionRoomId);
        PlayerQuestionSession playerQuestionSessionIntoDataBase = questionSessionService.findActiveQuestionInSession(playerGameSessionRoomId);
        LOGGER.info("A busca por questões ativas na sessão do usuário pelo id [{}] retornou o valor: [{}]", playerGameSessionRoomId, playerQuestionSessionIntoDataBase);

        if (Objects.nonNull(playerQuestionSessionIntoDataBase)) {
            LOGGER.info("Foi encontrada uma sessão ativa na base de dados de id [{}] ", playerQuestionSessionIntoDataBase.getId());
            addValuesIntoInGameQuestionAndAlternativesDTO(playerQuestionSessionIntoDataBase, inGameQuestionAndAlternativesDTO);
            inGameQuestionAndAlternativesDTO.setUserMessage("Existe uma questão ativa na sua sessão, termine o jogo atual antes de solicitar uma nova questão!");
            return inGameQuestionAndAlternativesDTO;
        } else {
            if (playerGameplaySessionDTO.getSessionActivated()) {
                LOGGER.info("A sessão da gameplay está ativa! sessionActivated =[{}] Iniciando geração de questão randomica.", true);
                try {
                    PlayerQuestionSession playerQuestionSession = this.questionSessionService.getRandomNotUsedQuestion();
                    playerQuestionSession.setQuestionIsActive(true);
                    LOGGER.info("A questão [{}] será inserida e retornada para o usuário como ativa.", playerQuestionSession);

                    this.questionSessionService.save(playerQuestionSession);
                    LOGGER.info("A questão foi atualizada na base de dados. [{}]", playerQuestionSession);

                    addValuesIntoInGameQuestionAndAlternativesDTO(playerQuestionSession, inGameQuestionAndAlternativesDTO);
                    LOGGER.info("inGameQuestionAndAlternativesDTO recebeu os dados de playerQuestionSession o valor foi: [{}]", inGameQuestionAndAlternativesDTO);
                } catch (Exception ex) {
                    LOGGER.error("Erro ao tentar buscar dados da questão na sessão. Erro: ", ex);
                }
                LOGGER.info("A questão foi gerada pelo sistema, a questão encontrada foi: [{}]", inGameQuestionAndAlternativesDTO);
            } else {
                LOGGER.info("A Sessão do usuário não está ativa, é necessário ter uma sessão ativa para continuar.");
            }
            inGameQuestionAndAlternativesDTO.setUserMessage("Muito bem meu caro jogador responda a pergunta para continuar o jogo!");
            return inGameQuestionAndAlternativesDTO;
        }
    }

    public InGameAlternativeResponse validatePLayerQuestionAlternative(Long gameplaySessionId, String selectedAlternative) {
        PlayerQuestionSession activeQuestionInSession = questionSessionService.findActiveQuestionInSession(gameplaySessionId);
        InGameAlternativeResponse inGameAlternativeResponse = new InGameAlternativeResponse();
        List<Alternative> currentSessionAlternativeList = null;

        if (Objects.isNull(activeQuestionInSession)) {
            inGameAlternativeResponse.setPlayerMessage(userIdNotExistErrorMessage() + gameplaySessionId);
            LOGGER.warn(userIdNotExistErrorMessage() + "[{}]", gameplaySessionId);
        } else {
            LOGGER.info("Foi encontrada um id válido de sessão para o usuário, a sessão encontrada foi: [{}] Iniciando filtro de alternativas", activeQuestionInSession);
            currentSessionAlternativeList = activeQuestionInSession.getQuestion().getAlternativeList();
            Optional<Alternative> correctSessionAlternative = getCorrectSessionAlternative(currentSessionAlternativeList);

            if (correctSessionAlternative.isPresent()) {
                if (isCorrectAlternative(correctSessionAlternative, selectedAlternative)) {
                    Long currentScoreWinPerSessionLevel = getWinScoreBySessionGamingLevel(gameplaySessionId);
                    inGameAlternativeResponse.setPlayerPunctuation(currentScoreWinPerSessionLevel);
                    activeQuestionInSession.setPlayerWin(true);

                    updateScorePlayerIntoSession(gameplaySessionId, currentScoreWinPerSessionLevel);
                    LOGGER.info("O jogador venceu! E ganhou pontos na sua sessão! Alternativa selecionada: [{}]", selectedAlternative);
                    inGameAlternativeResponse.setPlayerMessage("O jogador venceu! E ganhou pontos na sua sessão!");
                } else {
                    inGameAlternativeResponse.setPlayerPunctuation(0L);
                    activeQuestionInSession.setPlayerWin(false);
                    LOGGER.info("O jogador perdeu! E não recebeu pontos na sessão até o momento!");
                    inGameAlternativeResponse.setPlayerMessage("O jogador perdeu! e não recebeu pontos na sessão até o momento!");
                }

                inGameAlternativeResponse.setCorrectAlternative(correctSessionAlternative.get().getReferenceLetter() + " - " + correctSessionAlternative.get().getAlternative());
                inGameAlternativeResponse.setSelectedAlternative(selectedAlternative);

                activeQuestionInSession.setQuestionIsActive(false);
                activeQuestionInSession.setWasPlayed(true);
                this.questionSessionService.save(activeQuestionInSession);

                if(isTheEndUserSession(gameplaySessionId)) {
                    setValuesToDisablePlayerSession(inGameAlternativeResponse, gameplaySessionId);
                }
            } else {
                LOGGER.error("A base de dados está inconsistente e tem alternativas cadastradas com nenhuma alternativa correta! O que impede o jogador de jogar corrtamente! verifique na lista de alternativas: [{}]", currentSessionAlternativeList);
            }
        }
        return inGameAlternativeResponse;
    }

    //TODO Ajustar apra tirar o cascate das chamadas que tem filho como lista, e ajustar os lugares que precisam disso para funcionar!
    //TODO problema de apagar o filho quando não passa a lista, está resolvido mas fica muito pesado assim!
    private void updateScorePlayerIntoSession(Long gameplaySessionId, Long currentScoreWinPerSessionLevel){
        PlayerGameplaySessionDTO playerGameplaySessionDTO = playerGameplaySessionService.findById(gameplaySessionId);
        playerGameplaySessionDTO.setScore(playerGameplaySessionDTO.getScore() + currentScoreWinPerSessionLevel);
        playerGameplaySessionService.save(playerGameplaySessionDTO);
    }

    private boolean isTheEndUserSession(Long gameplaySessionId){
        Long unplayedQuestions = questionSessionService.countUnplayedQuestions(gameplaySessionId);
        return unplayedQuestions < 1;
    }

    private void setValuesToDisablePlayerSession(InGameAlternativeResponse inGameAlternativeResponse, Long gameplaySessionId){
        inGameAlternativeResponse.setSessionOver(true);
        inGameAlternativeResponse.setSessionOverMessage("A Sessão chegou ao seu fim!");
        disableGameplaySession(gameplaySessionId);
        LOGGER.info("Chegou na ultima alternativa válida do sistema.");
    }

    private Long getWinScoreBySessionGamingLevel(Long gameplaySessionId){
        PlayerGameplaySessionDTO playerGameplaySessionDTO = playerGameplaySessionService.findBySessionActivatedAndId(true, gameplaySessionId);
        GameConfigurationDTO gameConfigurationDTO = gameConfigurationService.findByLevel(playerGameplaySessionDTO.getLevel());
        return gameConfigurationDTO.getScorePerHit();
    }

    /**Desativa a sessão atual buscando o id e colocando ela com o status false para a coluna sesstion activated */
    private void disableGameplaySession(Long gameplaySessionId){
        PlayerGameplaySessionDTO playerGameplaySessionDTO = playerGameplaySessionService.findById(gameplaySessionId);
        playerGameplaySessionDTO.setSessionActivated(false);
        playerGameplaySessionService.save(playerGameplaySessionDTO);
    }

    private Optional<Alternative> getCorrectSessionAlternative(List<Alternative> currentSessionAlternativeList){
        return currentSessionAlternativeList.stream()
                .filter(Alternative::getItsCorrect)
                .findFirst();
    }

    private boolean isCorrectAlternative(Optional<Alternative> correctSessionAlternative, String selectedAlternative) {
        LOGGER.info("Foi encontrada uma alvernativa para a sessão, agora será validada se a alternativa condiz com a alternative selecionada que é [{}] ", selectedAlternative);
        return correctSessionAlternative.map(alternative -> alternative.getReferenceLetter().equals(selectedAlternative)).orElse(false);
    }

    /**
     * Se o id passado do player achar uma sessão ativa, ele retorna true, se não false
     */
    private PlayerGameplaySessionDTO getSession(Long playerGameplaySessionId) {
        LOGGER.info("Iniciando busca por sessão ativa playerGameplaySessionId = [{}]", playerGameplaySessionId);
        PlayerGameplaySessionDTO playerGameplaySessionDTO = playerGameplaySessionService.findById(playerGameplaySessionId);
        LOGGER.info("Busca por sessão ativa terminada com sucesso! playerGameplaySessionValueDTO: [{}]", playerGameplaySessionDTO);
        return playerGameplaySessionDTO;
    }

    private static void addValuesIntoInGameQuestionAndAlternativesDTO(PlayerQuestionSession playerQuestionSession, InGameQuestionAndAlternativesDTO inGameQuestionAndAlternativesDTO) {

        List<Alternative> alternativesListedIntoOneQuestionOfSession = playerQuestionSession.getQuestion().getAlternativeList();
        List<InGameAlternativeDTO> inGameAlternativeDTOList = new ArrayList<>();

        inGameQuestionAndAlternativesDTO.setQuestion(playerQuestionSession.getQuestion().getQuestion());
        inGameQuestionAndAlternativesDTO.setQuestionId(playerQuestionSession.getQuestion().getId());

        for (Alternative alternative : alternativesListedIntoOneQuestionOfSession) {
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

    /**
     * Busca o usuário e valida se ele existe na base de dados e só deixa passar se caso exista mesmo!
     */
    private UserDTO findUserById(Long userId) {
        Optional<UserDTO> userDTO = Optional.ofNullable(userService.findUserById(userId));
        try {
            if (userDTO.isEmpty()) {
                throw new UserNotFoundException(userNotFoundMessage(userId));
            }
        } catch (UserNotFoundException ex) {
            //Uma exception por que não achou o usuário cai aqui!
            LOGGER.error("Ocorreu um erro no método findUserById: Erro:", ex);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, userNotFoundExternalMessage(), ex);
        } catch (Exception ex) {
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
        return "O id do usuário enviado não está dentro de nenhuma sala válida, crie uma sala com um id de usuário válido antes de iniciar um jogo";
    }

    private String userIdNotExistErrorMessage(){
        return "A sessão solicitada pelo requisitante não existe, não foi encontrado id de sessão válido para o valor informado id: ";
    }

}
