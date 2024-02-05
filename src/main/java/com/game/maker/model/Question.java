package com.game.maker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Entity
@Table(name = "tb_questao")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tema")
    private String theme;

    @Column(name = "pergunta")
    private String question;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Alternative> alternativeList = new ArrayList<>();


    public Question(){

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

    public List<Alternative> getAlternativeList() {
        return alternativeList;
    }

    public void setAlternativeList(List<Alternative> alternativeList) {
        this.alternativeList = alternativeList;
    }



    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", theme='" + theme + '\'' +
                ", question='" + question + '\'' +
                ", alternativeArrayList=" + alternativeList +
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

        public Builder questionAlternativeArrayList(ArrayList<Alternative> alternativeArrayList) {
            questionBuilder.setAlternativeList(alternativeArrayList);
            return this;
        }

        public Question build() {
            return questionBuilder;
        }
    }


}
