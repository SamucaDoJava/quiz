package com.game.maker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StartGameSessionParams {

    private Long userId;
    private String theme;
    private String level;

}
