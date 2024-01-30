package com.game.maker.model;

public class QuestionAlternative {

    private Long id;

    private String alternative;

    private Boolean isCorrect;
    private String reference;

    public QuestionAlternative(){

    }

    public QuestionAlternative(String reference, String alternative, Boolean isCorrect) {
        this.alternative = alternative;
        this.isCorrect = isCorrect;
        this.reference = reference;
    }

    public QuestionAlternative(Long id, String referenc, String alternative, Boolean isCorrect) {
        this.id = id;
        this.alternative = alternative;
        this.isCorrect = isCorrect;
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

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }


    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "QuestionAlternative: " +
                "---> id= " + id +
                "---> Reference= " + reference +
                "---> Alternative= " + alternative +
                "---> isCorrect= " + isCorrect;
    }
    
}
