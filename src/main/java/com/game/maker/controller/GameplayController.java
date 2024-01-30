package com.game.maker.controller;

import com.game.maker.dto.PlayerDTO;
import com.game.maker.dto.StartGameplayDTO;
import com.game.maker.model.Player;
import com.game.maker.model.User;
import com.game.maker.service.GameplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/gameplay")
public class GameplayController {

    @Autowired
    private GameplayService gameplayService;


    // TODO: Adicione lógica para iniciar o jogo
    @PostMapping("/start")
    public PlayerDTO startGameplay(@RequestBody StartGameplayDTO gameplayDTO) {
        System.out.println("pause start gameplay");
        PlayerDTO playerDTO = gameplayService.startQuizGameplay(gameplayDTO.getNickName(), gameplayDTO.getTheme(), gameplayDTO.getUser());
        return playerDTO;
    }

    @PostMapping("/validate-gameplay")
    public void validateAlternative(@RequestBody PlayerDTO playerDTO){
        gameplayService.validatePlayerQuestionIsCorrect(playerDTO);
    }

    @GetMapping("/punctuation")
    public void showMyPontuation() {
        System.out.println("pause punctuation");
        // TODO: Adicione lógica para mostrar a pontuação
    }


}

