package com.game.maker.service;

import com.game.maker.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class GameplayService {

    @Autowired
    private PlayRoomService playRoomService;


    /**Anter de jogar a gameplay, é necessário adicionar o jogador em uma sala, especifique o tema!*/
    public GameplaySessionDTO addPlayerToRomService(PlayerSessionDTO playerSessionDTO) {
        return playRoomService.addPlayerToRoomService(playerSessionDTO);
    }

    /**Agora com o nosso usuário já inserido na sala, vamos gerar uma sessão com questões vinculadas ao seu id de usuário
     * score e outros atributos, é aqui que o jogo está sendo montado. */
    public InGameSessionDTO generateSessionQuestionsForPlayer(Long userId, String theme) {
       return playRoomService.generateSessionQuestionsForPlayer(userId, theme);
    }

    public List<GameplaySessionDTO> getActiveSessions() {
        return playRoomService.getAllGameplaySession();
    }

    public List<GameplaySessionDTO> getGameplaySessionByTheme(String theme) {
        GameplaySessionDTO session = playRoomService.getGameplaySessionByTheme(theme).orElse(null);
        return session != null ? Collections.singletonList(session) : Collections.emptyList();
    }

    public InGameQuestionAndAlternativesDTO findRandomQuestionActiveInPlayerSession(InGameSessionDTO inGameSessionDTO){
        return playRoomService.findRandomQuestionActiveInPlayerSession(inGameSessionDTO);
    }

    public InGameAlternativeResponse validateAlternativeSession(Long gameplaySessionId, String selectedAlternative){
        return playRoomService.validatePLayerQuestionAlternative(gameplaySessionId, selectedAlternative);
    }

}
