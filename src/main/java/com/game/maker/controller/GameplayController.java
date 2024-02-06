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


    @PostMapping("/add-player-to-rom-by-theme")
    public GameplaySessionDTO addPlayerToRomTheme(@RequestBody PlayerSessionDTO playerSessionDTO){
        return gameplayService.addPlayerToRomService(playerSessionDTO);
    }

    @GetMapping("/load-player-questions-into-room-by-theme/{userId}/{theme}")
    public InGameSessionDTO loadPlayerQuestionIntoRoomByTheme(@PathVariable Long userId, @PathVariable String theme) {
       return gameplayService.generateSessionQuestionsForPlayer(userId, theme);
    }

    @GetMapping("/active-sessions")
    public List<GameplaySessionDTO> activeSessions(){
        return gameplayService.getActiveSessions();
    }

    @GetMapping("/find-sessions-by/{theme}")
    public List<GameplaySessionDTO> activeSessions(@PathVariable String theme) {
        return gameplayService.getGameplaySessionByTheme(theme);
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

