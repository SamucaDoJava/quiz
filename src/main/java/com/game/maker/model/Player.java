package com.game.maker.model;

public class Player {

    private Long id;
    private String nickName;
    private Integer score;
    private String theme;
    private User user;


    public Player(){

    }

    public Player(String nickName, Integer score, User user) {
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


    public static final class Builder {
        private Player player;

        private Builder() {
            player = new Player();
        }

        public static Builder aPlayer() {
            return new Builder();
        }

        public Builder id(Long id) {
            player.setId(id);
            return this;
        }

        public Builder nickName(String nickName) {
            player.setNickName(nickName);
            return this;
        }

        public Builder score(Integer score) {
            player.setScore(score);
            return this;
        }

        public Builder theme(String theme) {
            player.setTheme(theme);
            return this;
        }

        public Builder user(User user) {
            player.setUser(user);
            return this;
        }

        public Player build() {
            return player;
        }
    }

    @Override
    public String toString() {
        return "Player" +
                "\nid=" + id +
                "\nnickName='" + nickName +
                "\nscore=" + score +
                "\ntheme='" + theme +
                "\nuser=" + user;
    }

}
