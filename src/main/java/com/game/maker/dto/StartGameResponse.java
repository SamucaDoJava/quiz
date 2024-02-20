package com.game.maker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StartGameResponse {

  private Long gameplaySessionId;
  private String responseMessage;

}