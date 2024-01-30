package com.game.maker.dto;

import com.game.maker.model.User;

public class StartGameplayDTO {

    private String nickName;
    private String theme;
    private User user;


    public StartGameplayDTO(String nickName, String theme, User user) {
        this.nickName = nickName;
        this.theme = theme;
        this.user = user;
    }

    public StartGameplayDTO(){

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "StartGameplayDTO{" +
                "nickName='" + nickName + '\'' +
                ", theme='" + theme + '\'' +
                ", user=" + user +
                '}';
    }
}
