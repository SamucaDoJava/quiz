package com.game.maker.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("theme")
    private String theme;

    @JsonProperty("question")
    private String question;

    @JsonProperty("response")
    private String response;

    @JsonProperty("alternativeList")
    private ArrayList<AlternativeDTO> alternativeList = new ArrayList<>();

    @Override
    public String toString() {
        return "\n\nQuestionDTO:" +
                "\nid = " + id +
                "\ntheme = " + theme +
                "\nquestion = " + question +
                "\nresponse = " + response +
                "\nquestionAlternativeDTOArrayList = " + alternativeList;
    }
}
