package com.game.maker.service;

import com.game.maker.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class GameplayService {

    @Autowired
    private PlayRomService playRomService;


    /**Anter de jogar a gameplay, é necessário adicionar o jogador em uma sala, especifique o tema!*/
    public GameplaySessionDTO addPlayerToRomService(PlayerSessionDTO playerSessionDTO) {
        return playRomService.addPlayerToRoomService(playerSessionDTO);
    }

    /**Agora com o nosso usuário já inserido na sala, vamos de fato jogar, entrando na sala e obtendo uma questão filtrada pelo tema da sala*/
    public void enterRoomAndPlay(Long userId, String theme) {
        playRomService.enterRomAndPlay(userId, theme);
    }

    public List<GameplaySessionDTO> getActiveSessions() {
        return playRomService.getAllGameplaySession();
    }

    public List<GameplaySessionDTO> getGameplaySessionByTheme(String theme) {
        GameplaySessionDTO session = playRomService.getGameplaySessionByTheme(theme).orElse(null);
        return session != null ? Collections.singletonList(session) : Collections.emptyList();
    }
}
