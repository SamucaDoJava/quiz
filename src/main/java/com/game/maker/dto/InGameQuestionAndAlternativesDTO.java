package com.game.maker.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InGameQuestionAndAlternativesDTO {

    @JsonProperty("question")
    private String question;

    @JsonProperty("questionId")
    private Long questionId;

    @JsonProperty("inGameAlternativeDTO")
    private List<InGameAlternativeDTO> inGameAlternativeDTO = new ArrayList<>();

    @JsonProperty("userMessage")
    private String userMessage;

    @JsonProperty("unplayedQuestions")
    private Long unplayedQuestions;

    @Override
    public String toString() {
        return "\nInGameQuestionAndAlternativesDTO" +
                "\nquestion=" + question +
                "\ninGameAlternativeDTO Tamanho da lista=" + inGameAlternativeDTO.size() +
                "\nuserMessage= " + userMessage +
                "\nunplayedQuestions= " + unplayedQuestions;
    }

}
