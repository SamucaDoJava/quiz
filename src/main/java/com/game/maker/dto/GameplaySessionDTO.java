package com.game.maker.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameplaySessionDTO {

    @JsonProperty("theme")
    private String theme;

    @Schema(hidden = true)
    private List<PlayerDTO> playerDTOList = new ArrayList<>();

    public GameplaySessionDTO(String nickName, String theme, PlayerDTO playerDTO) {
        this.theme = theme;
        this.playerDTOList.add(playerDTO);
    }

    @Override
    public String toString() {
        return "GameplaySessionDTO: " +
                "\ntheme= " + theme +
                "\nplayerDTOList= " + playerDTOList;
    }
}
