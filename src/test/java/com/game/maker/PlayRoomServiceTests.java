package com.game.maker;

import com.game.maker.dto.InGameAlternativeResponse;
import com.game.maker.dto.InGameQuestionAndAlternativesDTO;
import com.game.maker.dto.InGameSessionDTO;
import com.game.maker.dto.PlayerSessionDTO;
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
	private static final String THEME = "CINEMA";
	private static final Long USER_ID = 1L;
	private static final String SELECTED_ALTERNATIVE = "A";
	private static final String LEVEL = "FACIL";

	@Test
	void startFullGameplay() {
		InGameSessionDTO inGameSessionDTO = loadValidPlayerWithQuestionsSession();

		//Primeiro ciclo respostas
		Long unplayedQuestions = findRandoQuestionIntoSession(inGameSessionDTO);
		respondQuestionIntoSession(inGameSessionDTO);
		LOGGER.info("\n\nUnplayedQuestions: [{}] no primeiro ciclo.", unplayedQuestions);

		//Demais ciclos respondendo sempre com a mesma alternativa.
		for(Long i = 1L; unplayedQuestions >= i;){
			if(unplayedQuestions == 0){
				LOGGER.info("Acabou as questões da gameplay! unplayedQuestions [{}]", unplayedQuestions);
			} else {
				LOGGER.info("\n\nUnplayedQuestions: [{}] dentro do for.", unplayedQuestions);
				unplayedQuestions = findRandoQuestionIntoSession(inGameSessionDTO);
				respondQuestionIntoSession(inGameSessionDTO);
			}
		}
	}

	InGameSessionDTO loadValidPlayerWithQuestionsSession(){
		PlayerSessionDTO playerSessionDTO = new PlayerSessionDTO(THEME, USER_ID);

		LOGGER.info("Iniciando o carregamento de dados para a sessão do usuário id: [{}]", USER_ID);
		InGameSessionDTO inGameSessionDTO = playRoomService.createSessionAndGeneratedQuestions(USER_ID, THEME, LEVEL);
		LOGGER.info("O Usuário de id: [{}] foi carregado com questões ativas para o tema [{}] e foi gerada a sessão de id: [{}]", USER_ID, THEME, inGameSessionDTO.getPlayerSessionQuestionId());
		return inGameSessionDTO;
	}

	Long findRandoQuestionIntoSession(InGameSessionDTO inGameSessionDTO){
		InGameQuestionAndAlternativesDTO inGameQuestionAndAlternativesDTO = playRoomService.findRandomQuestionActiveInPlayerSession(inGameSessionDTO);
		LOGGER.info("Status atual da alternativa a ser respondida antes de responder: [{}]", inGameQuestionAndAlternativesDTO.getUserMessage());
		return inGameQuestionAndAlternativesDTO.getUnplayedQuestions();
	}

	void respondQuestionIntoSession(InGameSessionDTO inGameSessionDTO){
		LOGGER.info("id da sessão antes de salvar alternativa escolhida: [{}]", inGameSessionDTO.getPlayerSessionQuestionId());
		InGameAlternativeResponse inGameAlternativeResponse = playRoomService.validatePLayerQuestionAlternative(inGameSessionDTO.getPlayerSessionQuestionId(), SELECTED_ALTERNATIVE);
		LOGGER.info("\nStatus da alternativa pós a resposta! final do ciclo de uma alternativa! [{}]\n", inGameAlternativeResponse.getPlayerMessage());
	}

}
