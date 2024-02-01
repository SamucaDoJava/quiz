package com.game.maker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {

    private Long id;
    private String theme;
    private String question;
    private String response;
    private Long correctQuestionAlternativeID;
    private ArrayList<QuestionAlternativeDTO> questionAlternativeDTOArrayList;

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
