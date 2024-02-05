package com.game.maker.controller;

import com.game.maker.dto.GameplaySessionDTO;
import com.game.maker.dto.PlayerSessionDTO;
import com.game.maker.dto.QuestionDTO;
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

    @GetMapping("/enter-rom-by-theme/{userId}/{theme}")
    public void startGameplay(@PathVariable Long userId, @PathVariable String theme) {
       gameplayService.enterRoomAndPlay(userId, theme);
    }

    @GetMapping("/active-sessions")
    public List<GameplaySessionDTO> activeSessions(){
        return gameplayService.getActiveSessions();
    }

    @GetMapping("/find-sessions-by/{theme}")
    public List<GameplaySessionDTO> activeSessions(@PathVariable String theme) {
        return gameplayService.getGameplaySessionByTheme(theme);
    }





 }

