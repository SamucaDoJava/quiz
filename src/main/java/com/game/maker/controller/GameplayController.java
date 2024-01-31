package com.game.maker.controller;

import com.game.maker.dto.GameplaySessionDTO;
import com.game.maker.dto.PlayerDTO;
import com.game.maker.dto.QuestionDTO;
import com.game.maker.model.GameplaySession;
import com.game.maker.service.GameplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gameplay")
public class GameplayController {

    @Autowired
    private GameplayService gameplayService;


    @PostMapping("/start")
    public PlayerDTO startGameplay(@RequestBody GameplaySessionDTO gameplayDTO) {
        System.out.println("pause start gameplay");
        return gameplayService.startQuizGameplay(gameplayDTO.getNickName(), gameplayDTO.getTheme(), gameplayDTO.getUserDTO());
    }

    @PostMapping("/validate-gameplay")
    public PlayerDTO validateAlternative(@RequestBody PlayerDTO playerDTO){
        return gameplayService.validateItPlayerQuestionIsCorrect(playerDTO);
    }

    @PostMapping("/find-player-question-by-id")
    public QuestionDTO findPlayerQuestionByID(@RequestBody Long id){
        return gameplayService.findPlayerQuestionAndAlternativesByQuestionId(id);
    }

    @GetMapping("/show-session")
    public GameplaySession showMyPontuation() {
        GameplaySession gameplaySession = gameplayService.getCurrentSession();
        System.out.println("A sessão atual de jogadores tem " + gameplaySession.getPlayerDTOList().size() + " usuários.");
        return gameplaySession;
    }


}

