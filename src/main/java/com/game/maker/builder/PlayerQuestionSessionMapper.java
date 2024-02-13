package com.game.maker.builder;

import com.game.maker.dto.PlayerQuestionSessionDTO;
import com.game.maker.model.PlayerQuestionSession;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayerQuestionSessionMapper {

    private final ModelMapper modelMapper;


    public PlayerQuestionSessionMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PlayerQuestionSessionDTO toDTO(PlayerQuestionSession model) {
        return modelMapper.map(model, PlayerQuestionSessionDTO.class);
    }

    public PlayerQuestionSession toEntity(PlayerQuestionSessionDTO dto) {
        return modelMapper.map(dto, PlayerQuestionSession.class);
    }

    public List<PlayerQuestionSessionDTO> toListDTO(List<PlayerQuestionSession> modelList) {
        return modelList.stream()
                .map(this::toDTO).collect(Collectors.toList());
    }

    public List<PlayerQuestionSession> toList(List<PlayerQuestionSessionDTO> dtosList) {
        return dtosList.stream()
                .map(this::toEntity).collect(Collectors.toList());
    }

}
