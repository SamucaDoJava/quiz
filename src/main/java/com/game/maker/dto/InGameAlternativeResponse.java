package com.game.maker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class InGameAlternativeResponse {

  @JsonProperty("playerMessage")
  private String playerMessage;

  @JsonProperty("questionScore")
  private Long questionScore;

  @JsonProperty("selectedAlternative")
  private String selectedAlternative;

  @JsonProperty("correctAlternative")
  private String correctAlternative;

  @JsonProperty("currentSessionScore")
  private Long currentSessionScore;

  @JsonProperty("isSessionOver")
  private boolean isSessionOver;

  @JsonProperty("sessionOverMessage")
  private String sessionOverMessage;

  @JsonProperty("currentQuestionPosition")
  private Long currentQuestionPosition;

}