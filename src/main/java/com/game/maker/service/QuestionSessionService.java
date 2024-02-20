package com.game.maker.service;

import com.game.maker.model.PlayerQuestionSession;
import com.game.maker.repository.PlayerQuestionSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionSessionService {

  @Autowired
  private PlayerQuestionSessionRepository playerQuestionSessionRepository;

  public PlayerQuestionSession getRandomNotUsedQuestion() {
    return playerQuestionSessionRepository.findRandomNotUsedQuestion();
  }

  public PlayerQuestionSession findByQuestionIdAndNotPlayedAndQuestionIsActive(Long questionId) {
    return playerQuestionSessionRepository.findByQuestionIdAndNotPlayedAndQuestionIsActive(questionId);
  }

  public PlayerQuestionSession findActiveUnansweredQuestionsInSession(Long sessionId, Long userId) {
    return playerQuestionSessionRepository.findActiveUnansweredQuestionsInSession(sessionId, userId);
  }

  public PlayerQuestionSession save(PlayerQuestionSession playerQuestionSession) {
    return playerQuestionSessionRepository.save(playerQuestionSession);
  }

  public Long countUnplayedQuestions(Long sessionId) {
    return playerQuestionSessionRepository.countUnplayedQuestions(sessionId);
  }

  public Long sumScoreForCurrentSessionUntilNow(Long userId) {
    return playerQuestionSessionRepository.sumScoreForCurrentSessionUntilNow(userId);
  }

}