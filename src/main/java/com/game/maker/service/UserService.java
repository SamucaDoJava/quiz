package com.game.maker.service;

import com.game.maker.builder.UserMapper;
import com.game.maker.dto.UserDTO;
import com.game.maker.model.User;
import com.game.maker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;


    public UserDTO findUserById(Long id) {
        User user = userRepository.findUserById(id).orElse(null);
        return (user != null) ? userMapper.toDTO(user) : null;
    }


    public UserDTO save(UserDTO userDTO){
        return userMapper.toDTO(userRepository.save(userMapper.toEntity(userDTO)));
    }

    public List<UserDTO> findAll(){
        return userMapper.toListDTO(userRepository.findAll());
    }

    public UserDTO findByEmailAndPassword(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password).orElse(null);
        return (user != null) ? (userMapper.toDTO(user)) : (null);
    }

}
