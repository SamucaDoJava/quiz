package com.game.maker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlternativeValidationParams {

  private Long userId;
  private Long gameplaySessionId;
  private String selectedAlternative;

}