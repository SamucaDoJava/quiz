package com.game.maker.repository;

import com.game.maker.model.PlayerQuestionSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlayerQuestionSessionRepository extends JpaRepository<PlayerQuestionSession, Long> {

    @Query("SELECT pq FROM PlayerQuestionSession pq WHERE pq.wasPlayed = false ORDER BY RANDOM() LIMIT 1")
    PlayerQuestionSession findRandomNotUsedQuestion();

    @Query("SELECT pq FROM PlayerQuestionSession pq " +
            "WHERE pq.question.id = :questionId " +
            "AND pq.wasPlayed = false " +
            "AND pq.questionIsActive = true")
    PlayerQuestionSession findByQuestionIdAndNotPlayedAndQuestionIsActive(@Param("questionId") Long questionId);

    @Query("SELECT pq FROM PlayerQuestionSession pq " +
            "WHERE (pq.wasPlayed = false OR pq.wasPlayed IS NULL) " +
            "AND pq.playerGameplaySession.sessionActivated = true " +
            "AND pq.questionIsActive = true " +
            "AND pq.playerGameplaySession.userId = :userId " +
            "AND pq.playerGameplaySession.id = :sessionId ")
    PlayerQuestionSession findActiveUnansweredQuestionsInSession(@Param("sessionId") Long sessionId, @Param("userId") Long userId);

    @Query("SELECT COUNT(pq) FROM PlayerQuestionSession pq " +
            "WHERE (pq.wasPlayed = false OR pq.wasPlayed IS NULL) " +
            "AND pq.playerGameplaySession.id = :sessionId")
    Long countUnplayedQuestions(@Param("sessionId") Long sessionId);


    @Query("SELECT SUM(pq.score) FROM PlayerQuestionSession pq " +
            "WHERE pq.wasPlayed = true " +
            "AND pq.playerWin = true " +
            "AND pq.playerGameplaySession.id = :sessionId")
    Long sumScoreForCurrentSessionUntilNow(@Param("sessionId") Long sessionId);

}