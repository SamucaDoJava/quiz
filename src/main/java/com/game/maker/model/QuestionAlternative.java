package com.game.maker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_alternativa")
public class QuestionAlternative {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "alternativa")
    private String alternative;

    @Column(name = "correta")
    private Boolean itsCorrect;

    @Column(name = "referencia")
    private String reference;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_questao")
    private Question question;


    public QuestionAlternative(){

    }

    public QuestionAlternative(String reference, String alternative, Boolean itsCorrect) {
        this.alternative = alternative;
        this.itsCorrect = itsCorrect;
        this.reference = reference;
    }

    public QuestionAlternative(Long id, String reference, String alternative, Boolean itsCorrect) {
        this.id = id;
        this.alternative = alternative;
        this.itsCorrect = itsCorrect;
        this.reference = reference;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }


    public Boolean getItsCorrect() {
        return itsCorrect;
    }

    public void setItsCorrect(Boolean correct) {
        itsCorrect = correct;
    }


    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "QuestionAlternative: " +
                "---> id= " + id +
                "---> Reference= " + reference +
                "---> Alternative= " + alternative +
                "---> isCorrect= " + itsCorrect;
    }


    public static final class Builder {
        private QuestionAlternative questionAlternative;

        private Builder() {
            questionAlternative = new QuestionAlternative();
        }

        public static Builder aQuestionAlternative() {
            return new Builder();
        }

        public Builder id(Long id) {
            questionAlternative.setId(id);
            return this;
        }

        public Builder alternative(String alternative) {
            questionAlternative.setAlternative(alternative);
            return this;
        }

        public Builder itsCorrect(Boolean itsCorrect) {
            questionAlternative.setItsCorrect(itsCorrect);
            return this;
        }

        public Builder reference(String reference) {
            questionAlternative.setReference(reference);
            return this;
        }

        public Builder question(Question question) {
            questionAlternative.setQuestion(question);
            return this;
        }

        public QuestionAlternative build() {
            return questionAlternative;
        }
    }
}
