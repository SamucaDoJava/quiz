package com.game.maker.dto;

import com.game.maker.model.PlayerGameplaySession;
import com.game.maker.model.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class PlayerQuestionSessionDTO {

    private Long id;

    private Question question;

    private Boolean wasPlayed;

    private Boolean playerWin;

    private Boolean questionIsActive;

    private PlayerGameplaySession playerGameplaySession;


}
