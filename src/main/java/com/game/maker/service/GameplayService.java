package com.game.maker.service;

import com.game.maker.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameplayService {

    @Autowired
    private PlayRoomService playRoomService;


    /**Agora com o nosso usuário já inserido na sala, vamos gerar uma sessão com questões vinculadas ao seu id de usuário
     * score e outros atributos, é aqui que o jogo está sendo montado. */
    public InGameSessionDTO generateSessionQuestionsForPlayer(Long userId, String theme, String level) {
       return playRoomService.createSessionAndGeneratedQuestions(userId, theme, level);
    }


    public InGameQuestionAndAlternativesDTO findRandomQuestionActiveInPlayerSession(InGameSessionDTO inGameSessionDTO){
        return playRoomService.findRandomQuestionActiveInPlayerSession(inGameSessionDTO);
    }

    public InGameAlternativeResponse validateAlternativeSession(Long gameplaySessionId, String selectedAlternative){
        return playRoomService.validatePLayerQuestionAlternative(gameplaySessionId, selectedAlternative);
    }

}
