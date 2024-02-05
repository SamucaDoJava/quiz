package com.game.maker.service;

import com.game.maker.dto.*;
import com.game.maker.exception.QuestionNotFoundException;
import com.game.maker.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PlayRomService {

    private List<GameplaySessionDTO> gameplaySessionList = new ArrayList<>();
    private @Autowired UserService userService;

    private @Autowired QuestionService questionService;

    private @Autowired PlayerGameplaySessionValuesService playerGameplaySessionValuesService;

    /**Adiciona o Player a uma sala filtrada pelo tema escolhido, caso o tema escolhido não tenha
     * ninguém na sala, uma sala será criada e guardada em memória. */
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
        if(filteredGameplaySession.isPresent()){
            filteredGameplaySession.get().getPlayerDTOList().add(playerDTO);
        } else {
            //Se não existir que dizer que ele escolheu um tema de sala vazia! Então o sistema cria a sala.
            filteredGameplaySession = Optional.of(new GameplaySessionDTO(nickName, theme, playerDTO));
            gameplaySessionList.add(filteredGameplaySession.get());
        }
        return filteredGameplaySession.get();
    }

    /**Percorre sessoes de gameplay atuais para saber se já existe alguma gameplay com esse tema do filtro
     * Se sim retorna a GameplaySessionDTO e todos os jogadores que estão jogando, se não retorna vazio. */
    public Optional<GameplaySessionDTO> getGameplaySessionByTheme(String theme) {
        return gameplaySessionList.stream()
                .filter(session -> session.getTheme().equals(theme))
                .findFirst();
    }

    public List<GameplaySessionDTO> getAllGameplaySession() {
        return gameplaySessionList;
    }

    /** Busca o usuário e valida se ele existe na base de dados e só deixa passar se caso exista mesmo! */
    private UserDTO findUserById(Long userId){
        Optional<UserDTO> userDTO = Optional.ofNullable(userService.findUserById(userId));
        try {
            if(userDTO.isEmpty()) {
                throw new UserNotFoundException(userNotFoundMessage(userId));
            }
        } catch (UserNotFoundException ex) {
            //Uma exception por que não achou o usuário cai aqui!
            ex.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, userNotFoundExternalMessage(), ex);
        } catch (Exception ex) {
            //Qualquer outra exception cai aqui!
            ex.getStackTrace();
        }
        return userDTO.orElse(null);
    }

    /**Valida se o user id já está em uma sala com o tema referenciado e caso esteja retorna uma lista de questões
     * para o Player responder. */
    public QuestionDTO enterRomAndPlay(Long userId, String theme) {
        List<QuestionDTO> questionDTOList = null;
        Optional<GameplaySessionDTO> gameplaySessionDTO = getGameplaySessionByTheme(theme);

        try {
            if(gameplaySessionDTO.isPresent()) {
                for(PlayerDTO playerDTO:gameplaySessionDTO.get().getPlayerDTOList()){
                    if(playerDTO.getUserId().equals(userId)){
                        questionDTOList = questionService.findByTheme(theme);
                    }
                }
             }
            if(Objects.isNull(questionDTOList)) {
                throw new QuestionNotFoundException(userNotHaveActiveQuestionsMessage());
            }
            saveQuestionsOfSessionIntoDataBase(questionDTOList, userId);
        } catch (QuestionNotFoundException ex) {
            //Uma exception por que não achou o usuário cai aqui!
            ex.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, userNotFoundExternalMessage(), ex);
        } catch (Exception ex) {
            //Qualquer outra exception cai aqui!
            ex.printStackTrace();
        }
        return null;
    }

    private void saveQuestionsOfSessionIntoDataBase(List<QuestionDTO> enterRomAndPlay, Long userId) {
        List<Long> questionIntoGameplayRomIdList = new ArrayList<>();
        PlayerGameplaySessionValuesDTO playerGameplaySessionValuesDTO = new PlayerGameplaySessionValuesDTO();

        for(QuestionDTO questionDTO: enterRomAndPlay) {
            questionIntoGameplayRomIdList.add(questionDTO.getId());
        }

        playerGameplaySessionValuesDTO.setQuestionIdList(questionIntoGameplayRomIdList);
        playerGameplaySessionValuesDTO.setUserId(userId);
        playerGameplaySessionValuesDTO.setSessionEnd(Boolean.FALSE);

        playerGameplaySessionValuesService.save(playerGameplaySessionValuesDTO);

        System.out.println("PlaerGameplaySessionValuesDTO salvo com lista de ids da questão: " + playerGameplaySessionValuesDTO);
    }


    private String userNotFoundMessage(Long userId){
        return "O usuário com id: " + userId + " não foi encontrado";
    }

    private String userNotFoundExternalMessage() {
        return "Ocorreu um erro ao tentar recuperar o usuário da sessão, retorno do erro: ";
    }

    private String userNotHaveActiveQuestionsMessage(){
        return "O id do usuário enviado não está dentro de nenhuma sala válida, crie uma sala com um id de usuário válido antes de iniciar um jogo";
    }

}
