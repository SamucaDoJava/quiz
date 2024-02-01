package com.game.maker.service;

import com.game.maker.builder.UserMapper;
import com.game.maker.repository.temp.UserRepository;
import com.game.maker.dto.UserDTO;
import com.game.maker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository; //TODO lembrar de mudar para o repository correto quando implementar o banco de dados.

    public UserDTO findUserById(Long id){
        //TODO O userRepository.findAll() está pegando de um pacote temp em repository, mudar par ao repository correto quando tiver um banco de dados.
        ArrayList<User> userList = userRepository.findAll();

        //TODO Remover o findAll() do repository quando estiver pegando de um banco real pegar diretamente o findById do hibernate.
        for(User userModel: userList) {
            if(userModel.getId().equals(id)) {
                return userMapper.toDTO(userModel);
            }
        }
        return null;
    }

    //TODO Trocar quando configurar um banco de dados é importante na linha 36 e 37 remover a logica e trocar por userRepository.save(userDTO);
    public UserDTO save(UserDTO userDTO){
        ArrayList<User> userList = userRepository.findAll();
        userList.add(userMapper.toEntity(userDTO));
        return userDTO;
    }

    public List<UserDTO> findAll(){
        return userMapper.toListDTO(userRepository.findAll());
    }

}
