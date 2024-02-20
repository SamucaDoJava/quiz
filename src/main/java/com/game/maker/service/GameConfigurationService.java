package com.game.maker.service;

import com.game.maker.builder.GameConfigurationMapper;
import com.game.maker.dto.GameConfigurationDTO;
import com.game.maker.model.GameConfiguration;
import com.game.maker.repository.GameConfigurationRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GameConfigurationService {

  private final Logger LOGGER = LogManager.getLogger(PlayerGameplaySessionService.class);
  private final GameConfigurationRepository gameConfigurationRepository;
  private final GameConfigurationMapper gameConfigurationMapper;

  public GameConfigurationService(GameConfigurationRepository gameConfigurationRepository, GameConfigurationMapper gameConfigurationMapper) {
    this.gameConfigurationRepository = gameConfigurationRepository;
    this.gameConfigurationMapper = gameConfigurationMapper;
  }

  public List<GameConfigurationDTO> findAll() {
    return gameConfigurationMapper.toListDTO(gameConfigurationRepository.findAll());
  }

  public GameConfigurationDTO findById(Long id) {
    GameConfiguration gameConfiguration = gameConfigurationRepository.findById(id)
        .orElseThrow(() ->
            new NoSuchElementException(msgError("findById")));
    return (gameConfiguration != null) ? (gameConfigurationMapper.toDTO(gameConfiguration)) : (null);
  }

  public List<GameConfigurationDTO> findByIds(List<Long> ids) {
    try {
      List<GameConfiguration> gameConfigurationList = gameConfigurationRepository.findAllById(ids);
      return gameConfigurationMapper.toListDTO(gameConfigurationList);
    } catch(DataAccessException ex) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, msgError("findByIds"), ex);
    }
  }

  public GameConfigurationDTO findByLevel(String configLevel) {
    GameConfiguration gameConfiguration = gameConfigurationRepository.findByLevelIgnoreCase(configLevel)
        .orElseThrow(() ->
            new NoSuchElementException(msgError("findByLevel")));
    return (gameConfiguration != null) ? (gameConfigurationMapper.toDTO(gameConfiguration)) : (null);
  }

  public GameConfigurationDTO save(GameConfigurationDTO gameConfigurationDTO) {
    try {
      GameConfiguration gameConfiguration = gameConfigurationRepository.save(gameConfigurationMapper.toEntity(gameConfigurationDTO));
      return gameConfigurationMapper.toDTO(gameConfiguration);
    } catch(Exception ex) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, msgError("save"), ex);
    }
  }

  private String msgError(String method) {
    return "Ocorreu um erro em game configuration ao tentar fazer a operação no método: " + method;
  }

}