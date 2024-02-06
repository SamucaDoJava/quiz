package com.game.maker.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InGameAlternativeResponse {

    private String playerMessage;
    private Long PlayerPunctuation;
    private String selectedAlternative;
    private String correctAlternative;

}
