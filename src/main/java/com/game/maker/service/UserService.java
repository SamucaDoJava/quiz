package com.game.maker.service;

import com.game.maker.builder.UserMapper;
import com.game.maker.dto.UserDTO;
import com.game.maker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public UserDTO findUserById(Long id){
        ArrayList<User> userList = StaticDataBaseOnlyForTests.staticUserDataBaseMjv();

        for(User userModel: userList) {
            if(userModel.getId().equals(id)) {
                return userMapper.toDTO(userModel);
            }
        }
        return null;
    }

}