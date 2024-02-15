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
	private static Long currentQuestionPosition = null;

	private InGameAlternativeResponse inGameAlternativeResponse;

	@Test
	void startFullGameplay() {
		//Carregando partida.
		StartGameResponse startGameResponse = loadValidPlayerWithQuestionSession();
		boolean callWorkflow = true;

		//Respondendo demais alternativas da sessão até que o retorno de unplayedQuestions seja 0 ou seja, não exista mais nenhuma alternativa sem responder na sessão.
		for(boolean i = true; i == callWorkflow;){

			findRandoQuestionIntoSession(USER_ID, startGameResponse.getGameplaySessionId());
			respondQuestionIntoSession(USER_ID, startGameResponse.getGameplaySessionId(), SELECTED_ALTERNATIVE);
			showLogInfo(currentQuestionPosition);

			if(currentQuestionPosition == 1) {
				callWorkflow = false;
			}
		}
	}

	private void showLogInfo(Long currentQuestionPosition){
		LOGGER.info("CurrentQuestionPosition: [{}] dentro do for. currentSessionScore: [{}] playerPontuation: [{}]", currentQuestionPosition, inGameAlternativeResponse.getCurrentSessionScore(), inGameAlternativeResponse.getQuestionScore());
	}

	StartGameResponse loadValidPlayerWithQuestionSession(){
		StartGameResponse startGameResponse = playRoomService.createSessionAndGeneratedQuestions(USER_ID, THEME, LEVEL);
		return startGameResponse;
	}

	void findRandoQuestionIntoSession(Long userId, Long gameplaySessionId){
		InGameQuestionAndAlternativesDTO inGameQuestionAndAlternativesDTO = playRoomService.findRandomQuestionActiveInPlayerSession(userId, gameplaySessionId);
	}

	void respondQuestionIntoSession(Long userId, Long gameplaySessionId, String selectedAlternative){
		this.inGameAlternativeResponse = playRoomService.validatePLayerQuestionAlternative(userId, gameplaySessionId, selectedAlternative);
		currentQuestionPosition = this.inGameAlternativeResponse.getCurrentQuestionPosition();
	}

}
