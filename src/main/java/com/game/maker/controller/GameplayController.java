package com.game.maker.controller;

import com.game.maker.dto.*;
import com.game.maker.service.GameplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gameplay")
public class GameplayController {

    @Autowired
    private GameplayService gameplayService;


    @PostMapping("/start")
    public StartGameResponse startGameplay(@RequestBody StartGameSessionParams startGameSessionParams) {
       return gameplayService.generateSessionQuestionsForPlayer(startGameSessionParams);
    }

    @GetMapping("/find-question-in-session/{userId}/{gameplaySessionId}")
    public InGameQuestionAndAlternativesDTO findQuestionInSession(@PathVariable Long userId, @PathVariable Long gameplaySessionId) {
        return gameplayService.findRandomQuestionActiveInPlayerSession(userId, gameplaySessionId);
    }

    @PostMapping("/validate-selected-question-alternative")
    public InGameAlternativeResponse validateQuestionAlternative(@RequestBody AlternativeValidationParams alternativeValidationParams) {
        return gameplayService.validateAlternativeSession(alternativeValidationParams);
    }

 }

