package com.game.maker.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class InGameAlternativeResponse {

    private String playerMessage;
    private Long PlayerPunctuation;
    private String selectedAlternative;
    private String correctAlternative;
    private boolean isSessionOver;
    private String sessionOverMessage;

}
