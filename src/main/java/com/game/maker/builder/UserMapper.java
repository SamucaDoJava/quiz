package com.game.maker.builder;

import com.game.maker.dto.UserDTO;
import com.game.maker.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserDTO toDTO(User model) {
        return modelMapper.map(model, UserDTO.class);
    }

    public User toEntity(UserDTO dto) {
        return modelMapper.map(dto, User.class);
    }

    public List<UserDTO> toListDTO(List<User> modelList) {
        return modelList.stream()
                .map(this::toDTO).collect(Collectors.toCollection(ArrayList::new));
    }

    public List<User> toList(List<UserDTO> dtosList) {
        return dtosList.stream()
                .map(this::toEntity).collect(Collectors.toCollection(ArrayList::new));
    }

}
