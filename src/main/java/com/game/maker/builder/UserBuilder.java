package com.game.maker.builder;

import com.game.maker.dto.UserDTO;
import com.game.maker.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserBuilder {


    private final ModelMapper modelMapper;


    public UserBuilder(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserDTO toDTO(User User) {
        return this.modelMapper.map(User, UserDTO.class);
    }

    public UserDTO toDTOBuilder(User user){
        return UserDTO.Builder.anUserDTO()
                .id(user.getId())
                .name(user.getName())
                .fullName(user.getFullName())
                .age(user.getAge())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public User toEntity(UserDTO UserDTO) {
        return this.modelMapper.map(UserDTO, User.class);
    }

}