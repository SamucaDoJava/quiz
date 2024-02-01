package com.game.maker.dto;

import com.game.maker.model.Question;
import com.game.maker.model.User;

import java.util.ArrayList;

public class PlayerDTO {

    private Long id;

    private String nickName;
    private Integer score;
    private User user;

    private String theme;

    private ArrayList<Question> playerQuestionsList;

    public PlayerDTO(){

    }

    public PlayerDTO(String nickName, Integer score, String theme, User user) {
        this.nickName = nickName;
        this.score = score;
        this.user = user;
        this.theme = theme;
    }

    public PlayerDTO(String nickName, Integer score, User user) {
        this.nickName = nickName;
        this.score = score;
        this.user = user;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public ArrayList<Question> getPlayerQuestionsList() {
        return playerQuestionsList;
    }

    public void setPlayerQuestionsList(ArrayList<Question> playerQuestionsList) {
        this.playerQuestionsList = playerQuestionsList;
    }

    @Override
    public String toString() {
        return "\n\nplayerDTO - id: " + id +
                "\nnickName='" + nickName +
                "\nscore=" + score +
                "\nuser=" + user +
                "\ntheme=" + theme;
    }
}
