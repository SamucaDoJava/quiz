package com.game.maker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_alternativa")
public class Alternative {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "alternativa")
    private String alternative;

    @Column(name = "correta")
    private Boolean itsCorrect;

    @Column(name = "letra-referencia")
    private String referenceLetter;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_questao")
    private Question question;


    public Alternative(){

    }

    public Alternative(String referenceLetter, String alternative, Boolean itsCorrect) {
        this.alternative = alternative;
        this.itsCorrect = itsCorrect;
        this.referenceLetter = referenceLetter;
    }

    public Alternative(Long id, String reference, String alternative, Boolean itsCorrect) {
        this.id = id;
        this.alternative = alternative;
        this.itsCorrect = itsCorrect;
        this.referenceLetter = referenceLetter;
    }

    public Alternative(Long id, String alternative, Boolean itsCorrect, String referenceLetter, Question question) {
        this.id = id;
        this.alternative = alternative;
        this.itsCorrect = itsCorrect;
        this.referenceLetter = referenceLetter;
        this.question = question;
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


    public String getReferenceLetter() {
        return referenceLetter;
    }

    public void setReferenceLetter(String referenceLetter) {
        this.referenceLetter = referenceLetter;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }


    @Override
    public String toString() {
        return "Alternative: " +
                "---> id= " + id +
                "---> ReferenceLetter= " + referenceLetter +
                "---> Alternative= " + alternative;
    }


    public static final class Builder {
        private Alternative alternativeBuilder;

        private Builder() {
            alternativeBuilder = new Alternative();
        }

        public static Builder anAlternative() {
            return new Builder();
        }

        public Builder id(Long id) {
            alternativeBuilder.setId(id);
            return this;
        }

        public Builder alternative(String alternative) {
            alternativeBuilder.setAlternative(alternative);
            return this;
        }

        public Builder itsCorrect(Boolean itsCorrect) {
            alternativeBuilder.setItsCorrect(itsCorrect);
            return this;
        }

        public Builder reference(String referenceLetter) {
            alternativeBuilder.setReferenceLetter(referenceLetter);
            return this;
        }

        public Builder question(Question question) {
            alternativeBuilder.setQuestion(question);
            return this;
        }

        public Alternative build() {
            return alternativeBuilder;
        }
    }
}
