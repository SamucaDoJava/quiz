package com.game.maker.model;

import java.util.ArrayList;

public class Player {

    private Long id;

    private String nickName;
    private Integer score;

    private String theme;

    private User user;

    private Question currentPlayerQuestion;

    private ArrayList<Question> playerQuestionsList;

    private QuestionAlternative selectedQuestionAlternative;

    public Player(){

    }

    public Player(String nickName, Integer score, User user) {
        this.nickName = nickName;
        this.score = score;
        this.user = user;
    }

    public Player(String nickName, Integer score, String theme, User user) {
        this.nickName = nickName;
        this.score = score;
        this.theme = theme;
        this.user = user;
    }

    public Player(Long id, String nickName, Integer score, String theme, User user) {
        this.id = id;
        this.nickName = nickName;
        this.score = score;
        this.theme = theme;
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

    public Question getCurrentPlayerQuestion() {
        return currentPlayerQuestion;
    }

    public void setCurrentPlayerQuestion(Question currentPlayerQuestion) {
        this.currentPlayerQuestion = currentPlayerQuestion;
    }

    public QuestionAlternative getSelectedQuestionAlternative() {
        return selectedQuestionAlternative;
    }

    public void setSelectedQuestionAlternative(QuestionAlternative selectedQuestionAlternative) {
        this.selectedQuestionAlternative = selectedQuestionAlternative;
    }

    @Override
    public String toString() {
        return "\n\nPlayerDTO - id: " + id +
                "\nNickName='" + nickName +
                "\nScore=" + score +
                "\nUser=" + user +
                "\nTheme=" + theme +
                "\nCurrent Question: " + currentPlayerQuestion +
                "\nSelectedQuestionAlternative: " + selectedQuestionAlternative;
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

        public Builder currentPlayerQuestion(Question currentPlayerQuestion) {
            player.setCurrentPlayerQuestion(currentPlayerQuestion);
            return this;
        }

        public Builder playerQuestionsList(ArrayList<Question> playerQuestionsList) {
            player.setPlayerQuestionsList(playerQuestionsList);
            return this;
        }

        public Builder selectedQuestionAlternative(QuestionAlternative selectedQuestionAlternative) {
            player.setSelectedQuestionAlternative(selectedQuestionAlternative);
            return this;
        }

        public Player build() {
            return player;
        }
    }
}
