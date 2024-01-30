package com.game.maker.model;

import java.util.ArrayList;

public class Question {

    private Long id;
    private String question;
    private String theme;
    private String response;

    private Long questionAlternativeID;

    private ArrayList<QuestionAlternative> questionAlternativeArrayList;

    public Question(){

    }

    public Question(String theme, String question, String response) {
        this.theme = theme;
        this.question = question;
        this.response = response;
    }

    public Question(Long id, String theme, String question, String response, Long questionAlternativeID, ArrayList<QuestionAlternative> questionAlternativeArrayList){
        this.id = id;
        this.theme = theme;
        this.question = question;
        this.response = response;
        this.questionAlternativeArrayList = questionAlternativeArrayList;
        this.questionAlternativeID = questionAlternativeID;
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
        return  "\n\n" +
                "id = " + id +
                "\nTheme = " + theme +
                "\nQuestion = " + question +
                "\nResponse = " + response;
    }


}
