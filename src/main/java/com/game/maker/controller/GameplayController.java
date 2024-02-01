package com.game.maker.controller;


import com.game.maker.dto.PlayerDTO;
import com.game.maker.dto.UserDTO;
import com.game.maker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gameplay")
public class GameplayController {

    @Autowired
    private UserService userService;

    @GetMapping("/validate-server")
    public String myServiceIsAlive(){
        return "Sim";
    }

    @GetMapping("/get-player-dto-by-id/{id}")
    public PlayerDTO getPlayerDtoById(@PathVariable Long id){
        return null;
    }

    @GetMapping("/find-user-by/{id}")
    public UserDTO findUserDTOById(@PathVariable Long id){
        return userService.findUserById(id);
    }

}
