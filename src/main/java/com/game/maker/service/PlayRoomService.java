package com.game.maker.service;

import com.game.maker.builder.QuestionMapper;
import com.game.maker.dto.*;
import com.game.maker.exception.QuestionNotFoundException;
import com.game.maker.exception.UserNotFoundException;
import com.game.maker.model.Alternative;
import com.game.maker.model.PlayerQuestionSession;
import com.game.maker.model.PlayerGameplaySession;
import com.game.maker.model.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PlayRoomService {

    private final Logger LOGGER = LogManager.getLogger(PlayRoomService.class);
    private final List<GameplaySessionDTO> gameplaySessionList = new ArrayList<>();
    private @Autowired UserService userService;
    private @Autowired QuestionService questionService;
    private @Autowired PlayerGameplaySessionService playerGameplaySessionService;
    private @Autowired QuestionMapper questionMapper;
    private @Autowired PlayerQuestionSessionService playerQuestionSessionService;
    private @Autowired AlternativeService alternativeService;

    /**
     * Adiciona o Player a uma sala filtrada pelo tema escolhido, caso o tema escolhido não tenha
     * ninguém na sala, uma sala será criada e guardada em memória com o player adicionado, mas só
     * ser o usuário e tema escolhido for válido! userId  e theme
     */
    public GameplaySessionDTO addPlayerToRoomService(PlayerSessionDTO playerSessionDTO) throws UserNotFoundException {
        String theme = playerSessionDTO.getTheme();
        Long userId = playerSessionDTO.getUserId();
        UserDTO userIntoDataBase = findUserById(userId);
        String nickName = null;

        Optional<UserDTO> userDTO = Optional.ofNullable(userService.findUserById(userId));
        if (userDTO.isPresent()) {
            nickName = userDTO.get().getNickName();
        }

        PlayerDTO playerDTO = new PlayerDTO(nickName, 0, theme, userIntoDataBase.getId());
        Optional<GameplaySessionDTO> filteredGameplaySession = getGameplaySessionByTheme(theme);

        //Se existir gameplay já presente apenas adiciona o PlayerDTO ao tema que ele escolheu!
        if (filteredGameplaySession.isPresent()) {
            filteredGameplaySession.get().getPlayerDTOList().add(playerDTO);
        } else {
            //Se não existir que dizer que ele escolheu um tema de sala vazia! Então o sistema cria a sala.
            filteredGameplaySession = Optional.of(new GameplaySessionDTO(theme, playerDTO));
            gameplaySessionList.add(filteredGameplaySession.get());
        }
        return filteredGameplaySession.get();
    }

    /**
     * Valida se o user id já está em uma sala com o tema referenciado e caso esteja cria para o
     * usuário uma sessão com questões filtradas pelo tema que ele escolheu. Para o usuário poder
     * usar essa chamada ele precisa está já dentro de uma sala para isso chamar o método addPlayerToRoomService
     * e após sair desse método ele terá uma sessão com questões carregadas pelo tema escolhido por ele. o método
     * retorna um valor de questionGameplaySessionId que é o id da sessão criada, isso é necessário para recuperar as questões
     * vinculadas ao player e para acessar os dados da gameplay gerada!
     */
    public InGameSessionDTO generateSessionQuestionsForPlayer(Long userId, String theme) {
        List<QuestionDTO> questionDTOList = null;
        Optional<GameplaySessionDTO> gameplaySessionDTO = getGameplaySessionByTheme(theme);
        InGameSessionDTO inGameSessionDTO = null;
        try {
            questionDTOList = validateIfUserIntoRoom(gameplaySessionDTO, userId, theme);
            if (Objects.isNull(questionDTOList)) {
                throw new QuestionNotFoundException(userNotHaveActiveQuestionsMessage());
            }
            inGameSessionDTO = saveQuestionsOfSessionIntoDataBase(questionDTOList, userId);
        } catch (QuestionNotFoundException ex) {
            //Uma exception por que não achou o usuário cai aqui!
            LOGGER.error("Ocorreu um erro em generatedSessionForPlayer: ", ex);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, userNotFoundExternalMessage(), ex);
        } catch (Exception ex) {
            //Qualquer outra exception cai aqui!
            LOGGER.error("Ocorreu um erro em generatedSessionForPlayer: ", ex);
        }
        return inGameSessionDTO;
    }

    /**
     * Busca uma pergunta randomica dentro da sessão do usuário, lembrando que essa pergunta precisa estar com a coluna
     * isActivated como true se não ela já foi respondida e não será acessada na busca randomica.
     */
    public InGameQuestionAndAlternativesDTO findRandomQuestionActiveInPlayerSession(InGameSessionDTO inGameSessionDTO) {
        Long playerGameSessionRoomId = inGameSessionDTO.getPlayerSessionQuestionId();
        InGameQuestionAndAlternativesDTO inGameQuestionAndAlternativesDTO = new InGameQuestionAndAlternativesDTO();
        PlayerGameplaySessionDTO playerGameplaySessionDTO = getSession(playerGameSessionRoomId);

        Long unplayedQuestions = playerQuestionSessionService.countUnplayedQuestions(playerGameSessionRoomId);
        inGameQuestionAndAlternativesDTO.setUnplayedQuestions(unplayedQuestions);
        LOGGER.info("Quantidade de questões ainda não usadasa: [{}]", unplayedQuestions);

        LOGGER.info("Iniciando busca de questões ativas na sessão, a busca vai ser na base de dados, caso a sessão exista, não será criada outra! id da busca [{}]", playerGameSessionRoomId);
        PlayerQuestionSession playerQuestionSessionIntoDataBase = playerQuestionSessionService.findActiveQuestionInSession(playerGameSessionRoomId);
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
                    PlayerQuestionSession playerQuestionSession = this.playerQuestionSessionService.getRandomNotUsedQuestion();
                    playerQuestionSession.setQuestionIsActive(true);
                    LOGGER.info("A questão [{}] será inserida e retornada para o usuário como ativa.", playerQuestionSession);

                    this.playerQuestionSessionService.save(playerQuestionSession);
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

    //TODO Inserir logica de guardar a pontuação na sessão e ajudar a logica de validação da questão.
    public InGameAlternativeResponse validatePLayerQuestionAlternative(Long gameplaySessionId, String selectedAlternative) {
        PlayerQuestionSession activeQuestionInSession = playerQuestionSessionService.findActiveQuestionInSession(gameplaySessionId);
        InGameAlternativeResponse inGameAlternativeResponse = new InGameAlternativeResponse();
        List<Alternative> currentSessionAlternativeList = null;

        if (Objects.isNull(activeQuestionInSession)) {
            inGameAlternativeResponse.setPlayerMessage(userIdNotExistErrorMessage() + gameplaySessionId);
            LOGGER.warn(userIdNotExistErrorMessage() + "[{}]", gameplaySessionId);
        } else {
            LOGGER.info("Foi encontrada um id válido de sessão para o usuário, a sessão encontrada foi: [{}] Iniciando filtro de alternativas", activeQuestionInSession);
            currentSessionAlternativeList = activeQuestionInSession.getQuestion().getAlternativeList();
            Optional<Alternative> correctSessionAlternative = getCorrectSessionAlternative(currentSessionAlternativeList);
            Long unplayedQuestions = playerQuestionSessionService.countUnplayedQuestions(gameplaySessionId);

            if (correctSessionAlternative.isPresent()) {
                if (isCorrectAlternative(correctSessionAlternative, selectedAlternative)) {
                    inGameAlternativeResponse.setPlayerPunctuation(100L);
                    activeQuestionInSession.setPlayerWin(true);
                    LOGGER.info("O jogador venceu! E ganhou pontos na sua sessão! Alternativa selecionada: [{}]", selectedAlternative);
                    inGameAlternativeResponse.setPlayerMessage("O jogador venceu! E ganhou pontos na sua sessão!");
                } else {
                    inGameAlternativeResponse.setPlayerPunctuation(0L);
                    activeQuestionInSession.setPlayerWin(false);
                    LOGGER.info("O jogador perdeu! e não recebeu pontos na sessão até o momento!");
                    inGameAlternativeResponse.setPlayerMessage("O jogador perdeu! e não recebeu pontos na sessão até o momento!");
                }

                inGameAlternativeResponse.setCorrectAlternative(correctSessionAlternative.get().getReferenceLetter() + " - " + correctSessionAlternative.get().getAlternative());
                inGameAlternativeResponse.setSelectedAlternative(selectedAlternative);

                activeQuestionInSession.setQuestionIsActive(false);
                activeQuestionInSession.setWasPlayed(true);
                this.playerQuestionSessionService.save(activeQuestionInSession);

                if(unplayedQuestions == 1) {
                    inGameAlternativeResponse.setSessionOver(true);
                    inGameAlternativeResponse.setSessionOverMessage("A Sessão chegou ao seu fim!");

                    disableGameplaySession(gameplaySessionId);
                    LOGGER.info("Chegou na ultima alternativa válida do sistema. unplayedQuestions: [{}] ", unplayedQuestions);
                }
            } else {
                LOGGER.error("A base de dados está inconsistente e tem alternativas cadastradas com nenhuma alternativa correta! O que impede o jogador de jogar corrtamente! verifique na lista de alternativas: [{}]", currentSessionAlternativeList);
            }
        }
        return inGameAlternativeResponse;
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
        return correctSessionAlternative.map(alternative -> alternative.getAlternative().equals(selectedAlternative)).orElse(false);
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

    /**
     * Percorre sessoes de gameplay atuais para saber se já existe alguma gameplay com esse tema do filtro
     * Se sim retorna a GameplaySessionDTO e todos os jogadores que estão jogando, se não retorna vazio.
     */
    public Optional<GameplaySessionDTO> getGameplaySessionByTheme(String theme) {
        return gameplaySessionList.stream()
                .filter(session -> session.getTheme().equalsIgnoreCase(theme))
                .findFirst();
    }

    public List<GameplaySessionDTO> getAllGameplaySession() {
        return gameplaySessionList;
    }

    /**
     * Valida se o usuário existe dentro da sala se sim retorna uma lista com questões referentes ao tema da sala.
     */
    private List<QuestionDTO> validateIfUserIntoRoom(Optional<GameplaySessionDTO> gameplaySessionDTO, Long userId, String theme) {
        if (gameplaySessionDTO.isPresent()) {
            for (PlayerDTO playerDTO : gameplaySessionDTO.get().getPlayerDTOList()) {
                if (playerDTO.getUserId().equals(userId)) {
                    return questionService.findByTheme(theme);
                }
            }
        }
        return null;
    }

    /**
     * Salva as questões dentro da base de dados de sessão, ou seja, pega a lista de questões padrão cadastradas no sistema e insere uma lista
     * de referencia delas na sessão do usuário que é criada com essa lista de referencia de questões filtradas pela sala que ele entrou
     * ou seja filtrada pelo tema que ele escolheu.
     */
    private InGameSessionDTO saveQuestionsOfSessionIntoDataBase(List<QuestionDTO> enterRoomQuestionList, Long userId) {
        List<PlayerQuestionSession> playerQuestionSessionList = new ArrayList<>();
        PlayerGameplaySession playerGameplaySession = new PlayerGameplaySession();

        //Cria a lista de questões da sessão do usuário pegando como base o id de questões previamente cadastradas no sistema.
        //Aqui só chega questões que já foram filtradas e estão dentro de uma sala especifica, por exemplo Sala Cinema!
        for (QuestionDTO questionDTO : enterRoomQuestionList) {
            Question enterRoomQuestion = questionMapper.toEntity(questionDTO);
            playerQuestionSessionList.add(new PlayerQuestionSession(enterRoomQuestion, playerGameplaySession, false));
        }

        //Como é o inicio da gameplay a sessão começa com questões ainda sem uso e score 0 e a sessaõ está ativa e tem uma referencia ao id do usuário.
        playerGameplaySession.setPlayerGameplaySessionQuestions(playerQuestionSessionList);
        playerGameplaySession.setUserId(userId);
        playerGameplaySession.setScore(0L);
        playerGameplaySession.setSessionActivated(true);

        Long playerGameplaySessionId = playerGameplaySessionService.save(playerGameplaySession).getId();
        LOGGER.info("playerGameplaySession foi salva na base de dados o valor salvo foi: [{}] ", playerGameplaySession);

        //Retorna objeto resumido para a controller apenas com dados importantes para a continuação da gameplay, o mais importante aqui é o questionGameplaySessionId
        //Para podermos buscar sempre a partida e atualizar ela conforme o jogar forjogando e acertando ou errando questões da sessão!
        InGameSessionDTO inGameSessionDTO = new InGameSessionDTO();
        inGameSessionDTO.setPlayerSessionQuestionId(playerGameplaySessionId);

        return inGameSessionDTO;
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
