package com.game.maker;

import com.game.maker.model.Question;
import com.game.maker.service.QuizDataBaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class QuizApplicationTests {

	@Autowired
	private QuizDataBaseService quizDataBaseService;

	@Test
	void dataBaseQuizTests() {
		ArrayList<Question> allQuestionsList = quizDataBaseService.showAllQuestions();

		System.out.println("Foram encontradas no total " + allQuestionsList.size() + " Questões de quiz.\n\n");

		System.out.println("Vamos listar apenas as com o tema Cinema: \n" + quizDataBaseService.findByTheme(allQuestionsList, "Cinema"));
		System.out.println("Foram encontrados " + quizDataBaseService.findByTheme(allQuestionsList, "Cinema").size() + " com o tema Cinema");

		System.out.println("\n");
		System.out.println("Agora vamos listar todas as questões do Quiz: " + allQuestionsList);
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
