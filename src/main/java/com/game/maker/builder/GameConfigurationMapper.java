package com.game.maker.builder;

import com.game.maker.dto.GameConfigurationDTO;
import com.game.maker.model.GameConfiguration;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GameConfigurationMapper {

  private final ModelMapper modelMapper;

  public GameConfigurationMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  public GameConfigurationDTO toDTO(GameConfiguration model) {
    return modelMapper.map(model, GameConfigurationDTO.class);
  }

  public GameConfiguration toEntity(GameConfigurationDTO dto) {
    return modelMapper.map(dto, GameConfiguration.class);
  }


  public List<GameConfigurationDTO> toListDTO(List<GameConfiguration> modelList) {
    return modelList.stream()
        .map(this::toDTO).collect(Collectors.toList());
  }

  public List<GameConfiguration> toList(List<GameConfigurationDTO> dtosList) {
    return dtosList.stream()
        .map(this::toEntity).collect(Collectors.toList());
  }

}