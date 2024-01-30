package com.game.maker.model;

public class Player {

    private Long id;

    private String nickName;
    private Integer score;

    private String tema;

    private User user;

    public Player(){

    }

    public Player(String nickName, Integer score, User user) {
        this.nickName = nickName;
        this.score = score;
        this.user = user;
    }

    public Player(String nickName, Integer score, String tema, User user) {
        this.nickName = nickName;
        this.score = score;
        this.tema = tema;
        this.user = user;
    }

    public Player(Long id, String nickName, Integer score, String tema, User user) {
        this.id = id;
        this.nickName = nickName;
        this.score = score;
        this.tema = tema;
        this.user = user;
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

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    @Override
    public String toString() {
        return "\n\nPlayer - id: " + id +
                "\nNickName='" + nickName +
                "\nScore=" + score +
                "\nUser=" + user;
    }
}
