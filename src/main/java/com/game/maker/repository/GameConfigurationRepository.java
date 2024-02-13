package com.game.maker.repository;

import com.game.maker.model.GameConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface GameConfigurationRepository extends JpaRepository<GameConfiguration, Long> {

    Optional<GameConfiguration> findByLevelIgnoreCase(String configLevel);

}
