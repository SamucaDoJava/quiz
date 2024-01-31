package com.game.maker.dto;

public class GameplaySessionDTO {

    private String nickName;
    private String theme;
    private UserDTO userDTO;


    public GameplaySessionDTO(String nickName, String theme, UserDTO userDTO) {
        this.nickName = nickName;
        this.theme = theme;
        this.userDTO = userDTO;
    }

    public GameplaySessionDTO(){

    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    @Override
    public String toString() {
        return "GameplaySessionDTO: " +
                "\nnickName= " + nickName +
                "\ntheme= " + theme +
                "\nuser= " + userDTO;
    }
}
