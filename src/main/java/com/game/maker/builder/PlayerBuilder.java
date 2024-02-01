package com.game.maker.builder;

import com.game.maker.dto.PlayerDTO;
import com.game.maker.model.Player;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PlayerBuilder {


    private final ModelMapper modelMapper;


    public PlayerBuilder(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PlayerDTO toDTO(Player player) {
        return this.modelMapper.map(player, PlayerDTO.class);
    }

    public Player toEntity(PlayerDTO playerDTO) {
        return this.modelMapper.map(playerDTO, Player.class);
    }

}
