package com.game.maker.controller;

import com.game.maker.dto.*;
import com.game.maker.service.GameplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gameplay")
public class GameplayController {

    @Autowired
    private GameplayService gameplayService;


    @GetMapping("/load-player-questions-into-room-by-theme/{userId}/{theme}/{level}")
    public InGameSessionDTO loadPlayerQuestionIntoRoomByTheme(@PathVariable Long userId, @PathVariable String theme, @PathVariable String level) {
       return gameplayService.generateSessionQuestionsForPlayer(userId, theme, level);
    }

    @PostMapping("/find-random-question-active-in-player-session")
    public InGameQuestionAndAlternativesDTO findRandomQuestionActiveInPlayerSession(@RequestBody InGameSessionDTO inGameSessionDTO) {
        return gameplayService.findRandomQuestionActiveInPlayerSession(inGameSessionDTO);
    }

    @GetMapping("/validate-question-its-correct/{gameplaySessionId}/{selectedAlternative}")
    public InGameAlternativeResponse validateSessionAlternative(@PathVariable Long gameplaySessionId, @PathVariable String selectedAlternative) {
        return gameplayService.validateAlternativeSession(gameplaySessionId, selectedAlternative);
    }

 }

