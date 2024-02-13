package com.game.maker.controller;

import com.game.maker.dto.InGameAlternativeResponse;
import com.game.maker.dto.InGameQuestionAndAlternativesDTO;
import com.game.maker.dto.InGameSessionDTO;
import com.game.maker.service.GameplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gameplay")
public class GameplayController {

    @Autowired
    private GameplayService gameplayService;


    @GetMapping("/start-gameplay/{userId}/{theme}/{level}")
    public InGameSessionDTO startGameplay(@PathVariable Long userId, @PathVariable String theme, @PathVariable String level) {
       return gameplayService.generateSessionQuestionsForPlayer(userId, theme, level);
    }

    @PostMapping("/find-question-in-session")
    public InGameQuestionAndAlternativesDTO findQuestionInSession(@RequestBody InGameSessionDTO inGameSessionDTO) {
        return gameplayService.findRandomQuestionActiveInPlayerSession(inGameSessionDTO);
    }

    @GetMapping("/validate-question-selected-alternative/{gameplaySessionId}/{selectedAlternative}")
    public InGameAlternativeResponse validateQuestionAlternative(@PathVariable Long gameplaySessionId, @PathVariable String selectedAlternative) {
        return gameplayService.validateAlternativeSession(gameplaySessionId, selectedAlternative);
    }

 }

