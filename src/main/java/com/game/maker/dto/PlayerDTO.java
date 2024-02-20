package com.game.maker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {

  private Long id;
  private String nickName;
  private Integer score;
  private String theme;
  private Long userId;
  private QuestionDTO currentPlayerQuestionDTO;
  private Long selectedQuestionAlternativeID;

  public PlayerDTO(String nickName, Integer score, String theme, Long userId) {
    this.nickName = nickName;
    this.score = score;
    this.theme = theme;
    this.userId = userId;
  }

  @Override
  public String toString() {
    return "\n\nPlayerDTO - id: " + id +
        "\nNickName='" + nickName +
        "\nScore=" + score +
        "\nTheme=" + theme +
        "\nCurrent Question: " + currentPlayerQuestionDTO +
        "\nselectedQuestionAlternativeID = " + selectedQuestionAlternativeID;
  }
}