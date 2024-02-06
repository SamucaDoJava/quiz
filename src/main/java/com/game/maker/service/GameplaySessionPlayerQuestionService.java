package com.game.maker.service;

import com.game.maker.model.GameplaySessionPlayerQuestion;
import com.game.maker.repository.GameplaySessionPlayerQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameplaySessionPlayerQuestionService {

    @Autowired
    private GameplaySessionPlayerQuestionRepository gameplaySessionPlayerQuestionRepository;


    public GameplaySessionPlayerQuestion getRandomNotUsedQuestion() {
        return gameplaySessionPlayerQuestionRepository.findRandomNotUsedQuestion();
    }

    public GameplaySessionPlayerQuestion findByQuestionIdAndNotPlayedAndQuestionIsActive(Long questionId) {
       return gameplaySessionPlayerQuestionRepository.findByQuestionIdAndNotPlayedAndQuestionIsActive(questionId);
    }

    public GameplaySessionPlayerQuestion findActiveQuestion(Long sessionId) {
        return gameplaySessionPlayerQuestionRepository.findActiveQuestion(sessionId);
    }

    public GameplaySessionPlayerQuestion save(GameplaySessionPlayerQuestion gameplaySessionPlayerQuestion) {
        return gameplaySessionPlayerQuestionRepository.save(gameplaySessionPlayerQuestion);
    }

}
