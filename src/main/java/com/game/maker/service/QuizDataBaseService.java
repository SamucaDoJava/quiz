package com.game.maker.service;

import com.game.maker.model.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class QuizDataBaseService {

    public ArrayList<Question> showAllQuestions(){
        ArrayList<Question> questionsList = new ArrayList<>();

        questionsList = StaticDataBaseOnlyForTests.staticDataBaseWithHardcode();
        return questionsList;
    }

    public ArrayList<Question> findByTheme(ArrayList<Question> allQuestions, String theme){
        ArrayList<Question> filteredQuestionsList = new ArrayList<>();

        for (Question question : allQuestions) {
            if (question.getTheme().equalsIgnoreCase(theme)) {
                filteredQuestionsList.add(question);
            }
        }
        return filteredQuestionsList;
    }


}
