package com.game.maker.dto;

public class QuestionAlternativeDTO {

    private Long id;

    private String alternative;

    private Boolean itsCorrect;
    private String reference;

    public QuestionAlternativeDTO(){

    }

    public QuestionAlternativeDTO(String reference, String alternative, Boolean itsCorrect) {
        this.alternative = alternative;
        this.itsCorrect = itsCorrect;
        this.reference = reference;
    }

    public QuestionAlternativeDTO(Long id, String referenc, String alternative, Boolean itsCorrect) {
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

    @Override
    public String toString() {
        return "QuestionAlternative: " +
                "---> id= " + id +
                "---> Reference= " + reference +
                "---> Alternative= " + alternative +
                "---> isCorrect= " + itsCorrect;
    }
    
}
