package com.game.maker.service;


import com.game.maker.builder.PlayerBuilder;
import com.game.maker.dto.PlayerDTO;
import com.game.maker.model.Player;
import com.game.maker.model.Question;
import com.game.maker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GameplayService {
    @Autowired
    private QuizDataBaseService quizDataBaseService;

    @Autowired
    private PlayerBuilder playerBuilder;

    public PlayerDTO startQuizGameplay(String nickName, String theme, User user) {
        PlayerDTO playerDTO = new PlayerDTO(nickName, 0, theme, user);

        ArrayList<Question> questionsList = quizDataBaseService.showAllQuestions();
        ArrayList<Question> filteredQuestionsList = quizDataBaseService.findByTheme(questionsList, playerDTO.getTheme());

        playerDTO.setPlayerQuestionsList(filteredQuestionsList);

        return playerDTO;
    }

    public PlayerDTO findPlayerById(Long id){
       User user = new User("name", "fullName", 38);
       Player playerModel = new Player("nickName", 1000, user);

        return playerBuilder.toDTO(playerModel);
    }

}
