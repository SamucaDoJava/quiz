package com.game.maker.repository;

import com.game.maker.model.PlayerGameplaySession;
import com.game.maker.model.PlayerQuestionSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PlayerGameplaySessionRepository extends JpaRepository<PlayerGameplaySession, Long> {

    @Query("SELECT pgs FROM PlayerGameplaySession pgs " +
            "WHERE pgs.sessionActivated = true " +
            "AND pgs.userId = :userId ")
    Optional<PlayerGameplaySession> findByUserId(Long userId);

    @Query("SELECT pq FROM PlayerQuestionSession pq " +
            "WHERE (pq.wasPlayed = false OR pq.wasPlayed IS NULL) " +
            "AND pq.playerGameplaySession.sessionActivated = true " +
            "AND pq.questionIsActive = true " +
            "AND pq.playerGameplaySession.id = :sessionId")
    PlayerQuestionSession findActiveQuestionInSession(@Param("sessionId") Long sessionId);

    List<PlayerGameplaySession> findByLevelIgnoreCase(String level);

    @Query("SELECT pgs FROM PlayerGameplaySession pgs " +
            "WHERE pgs.sessionActivated = true " +
            "AND pgs.level = :level " +
            "AND pgs.userId = :userId ")
    List<PlayerGameplaySession> findByActiveGameplaySessionByLevelAndUserId(@Param("level") String level, @Param("userId") Long userId);


    Optional<PlayerGameplaySession> findBySessionActivatedAndId(boolean isActive, Long gameplaySessionId);

}