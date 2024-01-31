package com.game.maker.dto;

import java.util.ArrayList;

public class QuestionDTO {

    private Long id;

    private String theme;
    private String question;
    private String response;

    private Long correctQuestionAlternativeID;

    private ArrayList<QuestionAlternativeDTO> questionAlternativeDTOArrayList;

    public QuestionDTO(){

    }

    public QuestionDTO(String theme, String question, String response) {
        this.theme = theme;
        this.question = question;
        this.response = response;
    }

    public QuestionDTO(String theme, String question, String response, ArrayList<QuestionAlternativeDTO> questionAlternativeArrayList) {
        this.theme = theme;
        this.question = question;
        this.response = response;
        this.questionAlternativeDTOArrayList = questionAlternativeArrayList;
    }

    public QuestionDTO(Long id, String theme, String question, String response, ArrayList<QuestionAlternativeDTO> questionAlternativeArrayList) {
        this.id = id;
        this.theme = theme;
        this.question = question;
        this.response = response;
        this.questionAlternativeDTOArrayList = questionAlternativeArrayList;
    }

    public QuestionDTO(Long id, String theme, String question, String response, Long correctQuestionAlternativeID, ArrayList<QuestionAlternativeDTO> questionAlternativeArrayList) {
        this.id = id;
        this.theme = theme;
        this.question = question;
        this.response = response;
        this.correctQuestionAlternativeID = correctQuestionAlternativeID;
        this.questionAlternativeDTOArrayList = questionAlternativeArrayList;
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

    public ArrayList<QuestionAlternativeDTO> getQuestionAlternativeDTOArrayList() {
        return questionAlternativeDTOArrayList;
    }

    public void setQuestionAlternativeDTOArrayList(ArrayList<QuestionAlternativeDTO> questionAlternativeDTOArrayList) {
        this.questionAlternativeDTOArrayList = questionAlternativeDTOArrayList;
    }

    @Override
    public String toString() {
        return "\n\nQuestionDTO:" +
                "\nid = " + id +
                "\ntheme = " + theme +
                "\nquestion = " + question +
                "\nresponse = " + response +
                "\ncorrectQuestionAlternativeID = " + correctQuestionAlternativeID +
                "\nquestionAlternativeDTOArrayList = " + questionAlternativeDTOArrayList;
    }

}
