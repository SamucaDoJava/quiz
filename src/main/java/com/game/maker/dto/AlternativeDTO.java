package com.game.maker.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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

  @JsonProperty("referenceLetter")
  private String referenceLetter;

  @JsonProperty("questionId")
  private Long questionId;

  @Override
  public String toString() {
    return "Alternative: " +
        "---> id= " + id +
        "---> Reference= " + referenceLetter +
        "---> isCorrect= " + itsCorrect +
        "---> Alternative= " + alternative +
        "---> Question Id= " + questionId;
  }

}