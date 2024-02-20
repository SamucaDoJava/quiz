package com.game.maker;

import com.game.maker.model.Alternative;
import com.game.maker.model.Question;
import com.game.maker.model.Theme;
import com.game.maker.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class QuestionAlternativePersistenceTests {

  @Autowired
  private QuestionRepository questionRepository;

  @Test
  public void persistenceAlternatives() {

    Question question = createQuestionTest();
    List<Alternative> alternativeList = createQuestionAlternativeTest(question);

    question.setAlternativeList(alternativeList);
    Question questionResponseDB = questionRepository.save(question);

    System.out.println("O nosso banco de dados retornou: " + questionResponseDB);
  }

  private Question createQuestionTest() {
    Question question = new Question();
    question.setTheme(new Theme("Cinema")); //TODO ajustar com novo objeto do tipo objeto theme.
    question.setQuestion("Qual é o filme mais premiado da história do Oscar?");
    return question;
  }

  private List<Alternative> createQuestionAlternativeTest(Question question) {
    List<Alternative> alternativeList = new ArrayList<>();

    Alternative alternativeA = new Alternative();
    alternativeA.setAlternative("A");
    alternativeA.setItsCorrect(true);
    alternativeA.setReferenceLetter("O Senhor dos Anéis: O Retorno do Rei");
    alternativeA.setQuestion(question);
    alternativeList.add(alternativeA);

    Alternative alternativeB = new Alternative();
    alternativeB.setAlternative("B");
    alternativeB.setItsCorrect(false);
    alternativeB.setReferenceLetter("Titanic");
    alternativeB.setQuestion(question);
    alternativeList.add(alternativeB);

    Alternative alternativeC = new Alternative();
    alternativeC.setAlternative("C");
    alternativeC.setItsCorrect(false);
    alternativeC.setReferenceLetter("Ben-Hur");
    alternativeC.setQuestion(question);
    alternativeList.add(alternativeC);

    Alternative alternativeD = new Alternative();
    alternativeD.setAlternative("D");
    alternativeD.setItsCorrect(false);
    alternativeD.setReferenceLetter("Gandhi");
    alternativeD.setQuestion(question);
    alternativeList.add(alternativeD);

    return alternativeList;
  }

}