package com.game.maker.dto;

import com.game.maker.model.GameplaySessionPlayerQuestion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerGameplaySessionValuesDTO {

    private Long id;

    private Long userId;

    private Long score;

    private Boolean sessionActivated;

    private List<GameplaySessionPlayerQuestion> gameplaySessionPlayerQuestionList = new ArrayList<>();

}
