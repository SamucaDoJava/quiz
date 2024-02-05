package com.game.maker.dto;

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

    private Boolean sessionEnd;

    private List<Long> questionIdList = new ArrayList<>();


}
