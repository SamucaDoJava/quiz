package com.game.maker.model;

import java.util.ArrayList;

public class Question {

    private Long id;

    private String theme;
    private String question;
    private String response;

    private Long correctQuestionAlternativeID;

    private ArrayList<QuestionAlternative> questionAlternativeArrayList;

    public Question(){

    }

    public Question(String theme, String question, String response) {
        this.theme = theme;
        this.question = question;
        this.response = response;
    }

    public Question(String theme, String question, String response, ArrayList<QuestionAlternative> questionAlternativeArrayList) {
        this.theme = theme;
        this.question = question;
        this.response = response;
        this.questionAlternativeArrayList = questionAlternativeArrayList;
    }

    public Question(Long id, String theme, String question, String response, ArrayList<QuestionAlternative> questionAlternativeArrayList) {
        this.id = id;
        this.theme = theme;
        this.question = question;
        this.response = response;
        this.questionAlternativeArrayList = questionAlternativeArrayList;
    }

    public Question(Long id, String theme, String question, String response, Long correctQuestionAlternativeID, ArrayList<QuestionAlternative> questionAlternativeArrayList) {
        this.id = id;
        this.theme = theme;
        this.question = question;
        this.response = response;
        this.correctQuestionAlternativeID = correctQuestionAlternativeID;
        this.questionAlternativeArrayList = questionAlternativeArrayList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getCorrectQuestionAlternativeID() {
        return correctQuestionAlternativeID;
    }

    public void setCorrectQuestionAlternativeID(Long correctQuestionAlternativeID) {
        this.correctQuestionAlternativeID = correctQuestionAlternativeID;
    }

    public ArrayList<QuestionAlternative> getQuestionAlternativeArrayList() {
        return questionAlternativeArrayList;
    }

    public void setQuestionAlternativeArrayList(ArrayList<QuestionAlternative> questionAlternativeArrayList) {
        this.questionAlternativeArrayList = questionAlternativeArrayList;
    }

    @Override
    public String toString() {
        return  "\n\n" +
                "id = " + id +
                "\nTheme = " + theme +
                "\nQuestion = " + question +
                "\nResponse = " + response +
                "\nCorrect Question id = " + correctQuestionAlternativeID;
    }


}
