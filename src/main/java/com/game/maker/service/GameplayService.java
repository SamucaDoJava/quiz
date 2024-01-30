package com.game.maker.service;

import com.game.maker.dto.PlayerDTO;
import com.game.maker.model.Player;
import com.game.maker.model.Question;
import com.game.maker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

@Service
public class GameplayService {

    @Autowired
    private QuizDataBaseService quizDataBaseService;


    public PlayerDTO startQuizGameplay(String nickName, String theme, User user) {
        PlayerDTO playerDTO = new PlayerDTO(nickName, 0, theme, user);
        ArrayList<Question> questionsList = quizDataBaseService.showAllQuestions();
        ArrayList<Question> filteredQuestionsList = quizDataBaseService.findByTheme(questionsList, playerDTO.getTheme());

        playerDTO.setPlayerQuestionsList(filteredQuestionsList);
        return playerDTO;
    }

    public Boolean validatePlayerQuestionIsCorrect(PlayerDTO playerDTO) {
        Iterator<Question> iterator = playerDTO.getPlayerQuestionsList().iterator();

        System.out.println("Quantidade atual de perguntas no quiz para o playerDTO: " + playerDTO.getPlayerQuestionsList().size());

        while (iterator.hasNext()) {
            Question questionPosition = iterator.next();
            String questionPositionStr = questionPosition.getQuestion().toUpperCase();
            String currentPlayerQuestionStr = playerDTO.getCurrentPlayerQuestion().getTheme().toUpperCase();

            if (questionPositionStr.equals(currentPlayerQuestionStr)) {
                Boolean questionItsCorrect = playerDTO.getSelectedQuestionAlternative().getItsCorrect();

                if (questionItsCorrect) {
                    iterator.remove(); // Remove a posição do array se a questão for correta
                    System.out.println("O playerDTO acertou a resposta! A resposta é: " + questionPositionStr);
                    System.out.println("Quantidade atual de perguntas no quiz para o playerDTO: " + playerDTO.getPlayerQuestionsList().size());
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

}
