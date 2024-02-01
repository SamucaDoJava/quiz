package com.game.maker.model;

import com.game.maker.dto.QuestionAlternativeDTO;

import java.util.ArrayList;

public class QuestionAlternative {

    private Long id;

    private String alternative;

    private Boolean itsCorrect;
    private String reference;

    private Long questionId;

    private ArrayList<QuestionAlternativeDTO> questionAlternativeList;

    public QuestionAlternative(){

    }

    public QuestionAlternative(String reference, String alternative, Boolean itsCorrect) {
        this.alternative = alternative;
        this.itsCorrect = itsCorrect;
        this.reference = reference;
    }

    public QuestionAlternative(Long id, String reference, String alternative, Boolean itsCorrect, Long questionId) {
        this.id = id;
        this.alternative = alternative;
        this.itsCorrect = itsCorrect;
        this.reference = reference;
        this.questionId = questionId;
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

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public ArrayList<QuestionAlternativeDTO> getQuestionAlternativeList() {
        return questionAlternativeList;
    }

    public void setQuestionAlternativeList(ArrayList<QuestionAlternativeDTO> questionAlternativeList) {
        this.questionAlternativeList = questionAlternativeList;
    }

    @Override
    public String toString() {
        return "QuestionAlternative: " +
                "---> id= " + id +
                "---> Reference= " + reference +
                "---> Alternative= " + alternative +
                "---> isCorrect= " + itsCorrect +
                "---> questionId= " + questionId;
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

        public Builder questionId(Long questionId) {
            questionAlternative.setQuestionId(questionId);
            return this;
        }

        public Builder questionAlternativeList(ArrayList<QuestionAlternativeDTO> questionAlternativeList) {
            questionAlternative.setQuestionAlternativeList(questionAlternativeList);
            return this;
        }

        public QuestionAlternative build() {
            return questionAlternative;
        }
    }
}
