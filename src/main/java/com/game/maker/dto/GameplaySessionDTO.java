package com.game.maker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameplaySessionDTO {

    private String nickName;
    private String theme;
    private UserDTO userDTO;

    @Override
    public String toString() {
        return "GameplaySessionDTO: " +
                "\nnickName= " + nickName +
                "\ntheme= " + theme +
                "\nuser= " + userDTO;
    }
}
