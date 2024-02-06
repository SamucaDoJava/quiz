package com.game.maker.repository;

import com.game.maker.model.GameplaySessionPlayerQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GameplaySessionPlayerQuestionRepository extends JpaRepository<GameplaySessionPlayerQuestion, Long> {

    @Query("SELECT pq FROM GameplaySessionPlayerQuestion pq WHERE pq.wasPlayed = false ORDER BY RANDOM() LIMIT 1")
    GameplaySessionPlayerQuestion findRandomNotUsedQuestion();

    @Query("SELECT pq FROM GameplaySessionPlayerQuestion pq " +
            "WHERE pq.question.id = :questionId " +
            "AND pq.wasPlayed = false " +
            "AND pq.questionIsActive = true")
    GameplaySessionPlayerQuestion findByQuestionIdAndNotPlayedAndQuestionIsActive(@Param("questionId") Long questionId);

    @Query("SELECT pq FROM GameplaySessionPlayerQuestion pq " +
            "WHERE pq.wasPlayed = false " +
            "AND pq.questionIsActive = true " +
             "AND pq.playerGameplaySession.id = :sessionId")
    GameplaySessionPlayerQuestion findActiveQuestion(@Param("sessionId") Long sessionId);

}