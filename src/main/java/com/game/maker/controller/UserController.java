package com.game.maker.controller;

import com.game.maker.dto.LoginDTO;
import com.game.maker.dto.UserDTO;
import com.game.maker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @PostMapping("save")
    public UserDTO save(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @GetMapping
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @PostMapping("login")
    public UserDTO findByEmailPassword(@RequestBody LoginDTO loginDTO) {
        return userService.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
    }


}

