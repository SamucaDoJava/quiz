package com.game.maker.builder;

import com.game.maker.dto.PlayerDTO;
import com.game.maker.model.Player;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayerMapper {

    private final ModelMapper modelMapper;

    public PlayerMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PlayerDTO toDTO(Player model) {
        return modelMapper.map(model, PlayerDTO.class);
    }

    public Player toEntity(PlayerDTO dto) {
        return modelMapper.map(dto, Player.class);
    }

    public ArrayList<PlayerDTO> toListDTO(List<Player> modelList) {
        return modelList.stream()
                .map(this::toDTO).collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Player> toList(List<PlayerDTO> dtosList) {
        return dtosList.stream()
                .map(this::toEntity).collect(Collectors.toCollection(ArrayList::new));
    }

}
