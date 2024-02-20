package com.game.maker.dto;

import com.game.maker.model.PlayerQuestionSession;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerGameplaySessionDTO {

  private Long id;
  private Long userId;
  private Long score;
  private Boolean sessionActivated;
  private String level;
  private List<PlayerQuestionSession> playerQuestionSessionList = new ArrayList<>();

}