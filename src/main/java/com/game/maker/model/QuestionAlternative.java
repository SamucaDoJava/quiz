package com.game.maker.model;

public class QuestionAlternative {

    private Long id;

    private String alternative;

    private Boolean itsCorrect;
    private String reference;

    public QuestionAlternative(){

    }

    public QuestionAlternative(Long id, String alternative, Boolean itsCorrect, String reference) {
        this.id = id;
        this.alternative = alternative;
        this.itsCorrect = itsCorrect;
        this.reference = reference;
    }

    public QuestionAlternative(Long id, String alternative, String reference, Boolean itsCorrect) {
        this.id = id;
        this.alternative = alternative;
        this.itsCorrect = itsCorrect;
        this.reference = reference;
        this.itsCorrect = itsCorrect;
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

    public void setItsCorrect(Boolean itsCorrect) {
        this.itsCorrect = itsCorrect;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "\n\nQuestionAlternative: " +
                "\n---> id= " + id +
                "\n---> Reference= " + reference +
                "\n---> Alternative= " + alternative +
                "\n---> isCorrect= " + itsCorrect;
    }
}
