package com.game.maker.controller;

import com.game.maker.dto.GameplaySessionDTO;
import com.game.maker.dto.PlayerDTO;
import com.game.maker.dto.QuestionDTO;
import com.game.maker.model.GameplaySession;
import com.game.maker.model.Question;
import com.game.maker.service.GameplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //TODO Arrumar está com erro!
    @GetMapping("/validate/{questionId}/{selectedQuestionAlternative}")
    public String validateAlternative(@PathVariable Long questionId, @PathVariable String selectedQuestionAlternative) {
        return gameplayService.validateItPlayerQuestionIsCorrect(questionId, selectedQuestionAlternative);
    }

    @GetMapping("/question/{id}")
    public QuestionDTO findPlayerQuestionByID(@PathVariable Long id){
        return gameplayService.findPlayerQuestionAndAlternativesByQuestionId(id);
    }

 }

