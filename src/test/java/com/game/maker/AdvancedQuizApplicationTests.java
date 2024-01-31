package com.game.maker;

import com.game.maker.dto.PlayerDTO;
import com.game.maker.model.Question;
import com.game.maker.model.User;
import com.game.maker.service.GameplayService;
import com.game.maker.service.QuizDataBaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class AdvancedQuizApplicationTests {

	@Autowired
	private QuizDataBaseService quizDataBaseService;

	@Autowired
	private GameplayService gameplayService;

	@Test
	void dataBaseQuizTests() {
		//showMyQuizDatabase();

		User user = new User("Samuel", "Samuel Ferreira Duarte", 38);
		PlayerDTO playerDTO = gameplayService.startQuizGameplay("Samuquinha", "Cinema", user);

		System.out.println("Meu playerDTO instanciado: " + playerDTO);
		System.out.println("E o nosso player tem a seguinte lista do quiz: " + playerDTO.getPlayerQuestionsList());
	}

	private void showMyQuizDatabase(){
		ArrayList<Question> allQuestionsList = quizDataBaseService.showAllQuestions();

		System.out.println("Meus dados do quiz: " + allQuestionsList);
		System.out.println("Pause:\n\n");

		System.out.println("Mostrando apenas o tema Cinema: \n" +
				quizDataBaseService.findByTheme(allQuestionsList, "Cinema"));
	}

	//Isso aqui só funciona se não tiver dependencias de configurações no resource como por exemplo configurações de banco de dados
	//Configurações de log ou qualquer outra.
	public static void main(String[] args) {
		QuizDataBaseService quizDataBaseServiceJavaWithoutSpring = new QuizDataBaseService();
		ArrayList<Question> allQuestionsList = quizDataBaseServiceJavaWithoutSpring.showAllQuestions();

		System.out.println("Meus dados do quiz: " + allQuestionsList);

		System.out.println("Mostrando apenas o tema Cinema: \n" +
				quizDataBaseServiceJavaWithoutSpring.findByTheme(allQuestionsList, "Cinema"));

		System.out.println("Pause:\n\n");
	}



}
