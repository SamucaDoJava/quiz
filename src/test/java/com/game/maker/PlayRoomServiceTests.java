package com.game.maker;

import com.game.maker.dto.InGameAlternativeResponse;
import com.game.maker.dto.InGameQuestionAndAlternativesDTO;
import com.game.maker.dto.StartGameResponse;
import com.game.maker.service.PlayRoomService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlayRoomServiceTests {

    private final Logger LOGGER = LogManager.getLogger(PlayRoomServiceTests.class);

    @Autowired
    private PlayRoomService playRoomService;
    private static final String THEME = "Filme Terror";
    private static final Long USER_ID = 1L;
    private static final String SELECTED_ALTERNATIVE = "D";
    private static final String LEVEL = "Dificil";

    @Test
    void startFullGameplay() {
        //Carregando partidas.
        StartGameResponse startGameplayPlayerOne = loadValidPlayerWithQuestionSession(1L);
        //StartGameResponse startGameplayPlayerTwo = loadValidPlayerWithQuestionSession(2L);

        //callAllWorkflowFotTwoPlayer(1L, startGameplayPlayerOne.getGameplaySessionId(), 2L, startGameplayPlayerTwo.getGameplaySessionId());
        callAllWorkflowForOneSessionPlayer(1L, startGameplayPlayerOne.getGameplaySessionId());
    }

    private void callAllWorkflowFotTwoPlayer(Long userIdPlayerOne, Long sessionIdPlayerOne, Long userIdPlayerTwo, Long sessionIdPlayerTwo) {
        InGameAlternativeResponse inGameAlternativeResponsePlaterOne;
        InGameAlternativeResponse inGameAlternativeResponsePlayerTwo;
        Long currentQuestionPositionPlayerOne = null;
        Long currentQuestionPositionPlayerTwo = null;

        boolean callWorkflow = true;

        for (boolean i = true; i == callWorkflow;) {
            findRandoQuestionIntoSession(userIdPlayerOne, sessionIdPlayerOne);
            findRandoQuestionIntoSession(userIdPlayerTwo, sessionIdPlayerTwo);

            inGameAlternativeResponsePlaterOne = respondQuestionIntoSession(userIdPlayerOne, sessionIdPlayerOne, SELECTED_ALTERNATIVE);
            inGameAlternativeResponsePlayerTwo = respondQuestionIntoSession(userIdPlayerTwo, sessionIdPlayerTwo, SELECTED_ALTERNATIVE);

            currentQuestionPositionPlayerOne = inGameAlternativeResponsePlaterOne.getCurrentQuestionPosition();
            currentQuestionPositionPlayerTwo = inGameAlternativeResponsePlayerTwo.getCurrentQuestionPosition();

            if (currentQuestionPositionPlayerOne == 1 && currentQuestionPositionPlayerTwo == 1) {
                callWorkflow = false;
                LOGGER.info("Os dois jogadores tem chegaram ao fim do jogo! currentQuestionPositionPlayerOne [{}] currentQuestionPositionPlayerTwo [{}]", currentQuestionPositionPlayerOne, currentQuestionPositionPlayerTwo);
            }
        }
    }

    private void callAllWorkflowForOneSessionPlayer(Long userId, Long sessionId) {
        InGameAlternativeResponse inGameAlternativeResponse;
        Long currentQuestionPosition = null;
        boolean callWorkflow = true;

        for (boolean i = true; i == callWorkflow; ) {
            findRandoQuestionIntoSession(USER_ID, sessionId);
            inGameAlternativeResponse = respondQuestionIntoSession(USER_ID, sessionId, SELECTED_ALTERNATIVE);

            currentQuestionPosition = inGameAlternativeResponse.getCurrentQuestionPosition();

            if (currentQuestionPosition == 1) {
                callWorkflow = false;
            }
            LOGGER.info("inGameAlternativeResponse: [{}]", inGameAlternativeResponse);
        }
    }

    StartGameResponse loadValidPlayerWithQuestionSession(Long userId) {
        StartGameResponse startGameResponse = playRoomService.createSessionAndGeneratedQuestions(userId, THEME, LEVEL);
        return startGameResponse;
    }

    void findRandoQuestionIntoSession(Long userId, Long gameplaySessionId) {
        InGameQuestionAndAlternativesDTO inGameQuestionAndAlternativesDTO = playRoomService.findRandomQuestionActiveInPlayerSession(userId, gameplaySessionId);
    }

    InGameAlternativeResponse respondQuestionIntoSession(Long userId, Long gameplaySessionId, String selectedAlternative) {
        InGameAlternativeResponse inGameAlternativeResponse = playRoomService.validatePLayerQuestionAlternative(userId, gameplaySessionId, selectedAlternative);
        return inGameAlternativeResponse;
    }

}
