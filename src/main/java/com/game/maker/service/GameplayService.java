package com.game.maker.service;

import com.game.maker.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameplayService {

    @Autowired
    private PlayRoomService playRoomService;


    public StartGameResponse generateSessionQuestionsForPlayer(StartGameSessionParams startGameSessionParams) {
       return playRoomService.createSessionAndGeneratedQuestions(
               startGameSessionParams.getUserId(), startGameSessionParams.getTheme(), startGameSessionParams.getLevel());
    }

    public InGameQuestionAndAlternativesDTO findRandomQuestionActiveInPlayerSession(Long userId, Long gameplaySessionId){
        return playRoomService.findRandomQuestionActiveInPlayerSession(userId, gameplaySessionId);
    }

    public InGameAlternativeResponse validateAlternativeSession(AlternativeValidationParams alternativeValidationParams){
        return playRoomService.validatePLayerQuestionAlternative(
                alternativeValidationParams.getUserId(),
                alternativeValidationParams.getGameplaySessionId(),
                alternativeValidationParams.getSelectedAlternative());
    }

}
