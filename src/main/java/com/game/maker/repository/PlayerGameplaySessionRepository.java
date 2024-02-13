package com.game.maker.repository;

import com.game.maker.model.PlayerGameplaySession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerGameplaySessionRepository extends JpaRepository<PlayerGameplaySession, Long> {


}