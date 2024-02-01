package com.game.maker;

import com.game.maker.builder.PlayerBuilder;
import com.game.maker.dto.PlayerDTO;
import com.game.maker.model.Player;
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

	@Autowired
	private PlayerBuilder playerBuilder;

	@Test
	void dataBaseQuizTests() {
		//showMyQuizDatabase();
		//listUserGameplay();

		User user = new User();
		System.out.println("Pause");
	}

	private void exampleDTO(){
		Player playerModel = createNewPlayerModel();

		System.out.println("Mostre os dados em memoria do meu modelo: " + playerModel);

		System.out.println("Agora eu preciso pegar o meu modelo e enviar para a controller");
		System.out.println("Para isso eu preciso transformar ele em DTO do mesmo tipo");

		PlayerDTO playerDTO = null;
		System.out.println("\n\nInicialmente o meu objeto DTO começou valendo: " + playerDTO);

		System.out.println("Vamos passar os dados do modelo para o DTO");
		playerDTO = playerBuilder.toDTO(playerModel);

		System.out.println("Depois do mapper o meu objeto DTO tem o seguinte valor: " + playerDTO);

		System.out.println("Fim da aplicação");
	}

	private Player createNewPlayerModel(){
		Player playerModel = new Player();
		playerModel.setId(1L);
		playerModel.setScore(1000);
		playerModel.setNickName("Samuca");
		playerModel.setUser(createNewUser());
		return playerModel;
	}

	private User createNewUser(){
		User user = new User();
		user.setAge(38);
		user.setName("Samuel");
		user.setEmail("samucationx@gmail.com");
		return user;
	}

	private void listUserGameplay(){
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
//	public static void main(String[] args) {
//		QuizDataBaseService quizDataBaseServiceJavaWithoutSpring = new QuizDataBaseService();
//		ArrayList<Question> allQuestionsList = quizDataBaseServiceJavaWithoutSpring.showAllQuestions();
//
//		System.out.println("Meus dados do quiz: " + allQuestionsList);
//
//		System.out.println("Mostrando apenas o tema Cinema: \n" +
//				quizDataBaseServiceJavaWithoutSpring.findByTheme(allQuestionsList, "Cinema"));
//
//		System.out.println("Pause:\n\n");
//	}



}
