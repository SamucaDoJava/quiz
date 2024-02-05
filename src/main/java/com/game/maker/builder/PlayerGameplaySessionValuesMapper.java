package com.game.maker.builder;

import com.game.maker.dto.PlayerGameplaySessionValuesDTO;
import com.game.maker.model.PlayerGameplaySessionValues;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayerGameplaySessionValuesMapper {

    private final ModelMapper modelMapper;

    public PlayerGameplaySessionValuesMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PlayerGameplaySessionValuesDTO toDTO(PlayerGameplaySessionValues model) {
        return modelMapper.map(model, PlayerGameplaySessionValuesDTO.class);
    }

    public PlayerGameplaySessionValues toEntity(PlayerGameplaySessionValuesDTO dto) {
        return modelMapper.map(dto, PlayerGameplaySessionValues.class);
    }

    public List<PlayerGameplaySessionValuesDTO> toListDTO(List<PlayerGameplaySessionValues> modelList) {
        return modelList.stream()
                .map(this::toDTO).collect(Collectors.toList());
    }

    public List<PlayerGameplaySessionValues> toList(List<PlayerGameplaySessionValuesDTO> dtosList) {
        return dtosList.stream()
                .map(this::toEntity).collect(Collectors.toList());
    }
}
