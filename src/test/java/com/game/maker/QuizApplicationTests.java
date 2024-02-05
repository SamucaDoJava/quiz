package com.game.maker;

import com.game.maker.dto.UserDTO;
import com.game.maker.model.User;
import com.game.maker.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QuizApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	void dataBaseQuizTests() {

		UserDTO userDTO = new UserDTO("Samuel", "Samuel Ferreira Duarte", 38,"samucationx@gmail.com", "123Mudar");

		UserDTO userIntoDataBase = userService.save(userDTO);

		System.out.println("Retorno do objeto! " + userIntoDataBase);

	}



}
