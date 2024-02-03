package com.game.maker.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_questao")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tema")
    private String theme;

    @Column(name = "pergunta")
    private String question;

    @Column(name = "resposta")
    private String response;

    @Column(name = "id_alternativa_correta")
    private Long correctQuestionAlternativeID;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<QuestionAlternative> questionAlternativeArrayList;


    public Question(){

    }

    public Question(String theme, String question, String response) {
        this.theme = theme;
        this.question = question;
        this.response = response;
    }

    public Question(String theme, String question, String response, List<QuestionAlternative> questionAlternativeArrayList) {
        this.theme = theme;
        this.question = question;
        this.response = response;
        this.questionAlternativeArrayList = questionAlternativeArrayList;
    }

    public Question(Long id, String theme, String question, String response, List<QuestionAlternative> questionAlternativeArrayList) {
        this.id = id;
        this.theme = theme;
        this.question = question;
        this.response = response;
        this.questionAlternativeArrayList = questionAlternativeArrayList;
    }

    public Question(Long id, String theme, String question, String response, Long correctQuestionAlternativeID, List<QuestionAlternative> questionAlternativeArrayList) {
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

    public List<QuestionAlternative> getQuestionAlternativeArrayList() {
        return questionAlternativeArrayList;
    }

    public void setQuestionAlternativeArrayList(List<QuestionAlternative> questionAlternativeArrayList) {
        this.questionAlternativeArrayList = questionAlternativeArrayList;
    }


    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", theme='" + theme + '\'' +
                ", question='" + question + '\'' +
                ", response='" + response + '\'' +
                ", correctQuestionAlternativeID=" + correctQuestionAlternativeID +
                ", questionAlternativeArrayList=" + questionAlternativeArrayList +
                '}';
    }

    public static final class Builder {
        private Question questionBuilder;

        private Builder() {
            questionBuilder = new Question();
        }

        public static Builder aQuestion() {
            return new Builder();
        }

        public Builder id(Long id) {
            questionBuilder.setId(id);
            return this;
        }

        public Builder theme(String theme) {
            questionBuilder.setTheme(theme);
            return this;
        }

        public Builder question(String question) {
            questionBuilder.setQuestion(question);
            return this;
        }

        public Builder response(String response) {
            questionBuilder.setResponse(response);
            return this;
        }

        public Builder correctQuestionAlternativeID(Long correctQuestionAlternativeID) {
            questionBuilder.setCorrectQuestionAlternativeID(correctQuestionAlternativeID);
            return this;
        }

        public Builder questionAlternativeArrayList(ArrayList<QuestionAlternative> questionAlternativeArrayList) {
            questionBuilder.setQuestionAlternativeArrayList(questionAlternativeArrayList);
            return this;
        }

        public Question build() {
            return questionBuilder;
        }
    }


}
