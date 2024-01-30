package com.game.maker.service;

import com.game.maker.model.Player;
import com.game.maker.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameplayService {

    @Autowired
    private QuizDataBaseService quizDataBaseService;


    public void startQuizGameplay(Player player){

        ArrayList<Question> questionsList = quizDataBaseService.showAllQuestions();
        ArrayList<Question> filteredQuestionsList = quizDataBaseService.findByTheme(questionsList, player.getTema());




    }

    private void validateTheme(){

    }



}
