package com.game.maker.model;

public class Question {

    private String theme;
    private String question;
    private String response;

    public Question(){

    }

    public Question(String theme, String question, String response) {
        this.theme = theme;
        this.question = question;
        this.response = response;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "Question{" +
                "theme='" + theme + '\'' +
                ", question='" + question + '\'' +
                ", response='" + response + '\'' +
                '}';
    }


}
