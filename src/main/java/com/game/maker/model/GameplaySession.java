package com.game.maker.model;


import com.game.maker.dto.PlayerDTO;

import java.util.List;

public class GameplaySession {

    private List<PlayerDTO> playerDTOList;
    private PlayerDTO currentPlayerDtoWithMaxScore;


    public GameplaySession(){

    }

    public GameplaySession(List<PlayerDTO> playerDTOList) {
        this.playerDTOList = playerDTOList;
    }

    public List<PlayerDTO> getPlayerDTOList() {
        return playerDTOList;
    }

    public void setPlayerDTOList(List<PlayerDTO> playerDTOList) {
        this.playerDTOList = playerDTOList;
    }

    @Override
    public String toString() {
        return "\n\nGameplaySession:" +
                "\nplayerList=" + playerDTOList;
    }

}
