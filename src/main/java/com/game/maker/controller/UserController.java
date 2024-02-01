package com.game.maker.controller;

import com.game.maker.dto.UserDTO;
import com.game.maker.model.GameplaySession;
import com.game.maker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable Long id) {
        return userService.findUserById(id);
    }


}

