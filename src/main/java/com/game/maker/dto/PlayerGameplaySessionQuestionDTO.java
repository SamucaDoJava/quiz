package com.game.maker.dto;

import com.game.maker.model.PlayerGameplaySessionValues;
import com.game.maker.model.Question;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerGameplaySessionQuestionDTO {

    private Long id;

    private Question question;

    private Boolean wasPlayed;

    private Boolean playerWin;

    private Boolean questionIsActive;

    private PlayerGameplaySessionValues playerGameplaySession;


}
