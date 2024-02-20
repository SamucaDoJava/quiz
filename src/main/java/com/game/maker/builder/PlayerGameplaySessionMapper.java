package com.game.maker.builder;

import com.game.maker.dto.PlayerGameplaySessionDTO;
import com.game.maker.model.PlayerGameplaySession;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayerGameplaySessionMapper {

  private final ModelMapper modelMapper;

  public PlayerGameplaySessionMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  public PlayerGameplaySessionDTO toDTO(PlayerGameplaySession model) {
    PlayerGameplaySessionDTO playerGameplaySessionDTO = modelMapper.map(model, PlayerGameplaySessionDTO.class);
    playerGameplaySessionDTO.setPlayerQuestionSessionList(model.getPlayerGameplaySessionQuestions());
    return playerGameplaySessionDTO;
  }

  public PlayerGameplaySession toEntity(PlayerGameplaySessionDTO dto) {
    PlayerGameplaySession playerQuestionSession = modelMapper.map(dto, PlayerGameplaySession.class);
    playerQuestionSession.setPlayerGameplaySessionQuestions(dto.getPlayerQuestionSessionList());
    return playerQuestionSession;
  }

  public List<PlayerGameplaySessionDTO> toListDTO(List<PlayerGameplaySession> modelList) {
    return modelList.stream()
        .map(this::toDTO).collect(Collectors.toList());
  }

  public List<PlayerGameplaySession> toList(List<PlayerGameplaySessionDTO> dtosList) {
    return dtosList.stream()
        .map(this::toEntity).collect(Collectors.toList());
  }
}