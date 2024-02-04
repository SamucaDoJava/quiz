package com.game.maker.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlternativeDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("alternative")
    private String alternative;

    @JsonProperty("itsCorrect")
    private Boolean itsCorrect;

    @JsonProperty("reference")
    private String reference;

    @Column(name = "id_questao")
    private Long questionId;

    @Override
    public String toString() {
        return "Alternative: " +
                "---> id= " + id +
                "---> Reference= " + reference +
                "---> isCorrect= " + itsCorrect +
                "---> Alternative= " + alternative +
                "---> Id questao=";
    }
    
}
