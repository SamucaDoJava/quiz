package com.game.maker.controller;

import com.game.maker.model.Player;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/gameplay")
public class GameplayController {


    @PostMapping("/start")
    public void startGameplay(@RequestBody List<Player> playerList) {
        System.out.println("pause start gameplay");
        // TODO: Adicione lógica para iniciar o jogo
    }

    @PostMapping("/validate-gameplay")
    public void validateAlternative(@RequestParam String myAlternative,
                                    @RequestParam Long questionID,
                                    @RequestParam Long alternativeID) {
        System.out.println("Pause validate:");
        // TODO: Adicione lógica para validar a alternativa
    }

    @GetMapping("/punctuation")
    public void showMyPontuation() {
        System.out.println("pause punctuation");
        // TODO: Adicione lógica para mostrar a pontuação
    }
}

