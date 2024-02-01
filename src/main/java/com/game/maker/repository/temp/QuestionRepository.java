package com.game.maker.repository.temp;

import com.game.maker.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**TODO Use a mesma abordagem explicada na documentação de UserRepository.class para essa classe QuestionRepository.class
 * Lembrando que quando implementarmos o banco de dados essas classes com esses comentários vão todas modificadas e muito!
 * */
@Component
public class QuestionRepository {

    @Autowired
    private QuestionFakeDataBase questionFakeDataBase;

    public Question save(Question question) {
        questionFakeDataBase.ShowMeMyFakeQuestionDataBaseValues().add(question);
        return question;
    }

    public List<Question> findByTheme(String theme) {
        return questionFakeDataBase.ShowMeMyFakeQuestionDataBaseValues().stream()
                .filter(question -> question.getTheme().equals(theme))
                .collect(Collectors.toList());
    }

    public List<Question> findAll() {
        return questionFakeDataBase.ShowMeMyFakeQuestionDataBaseValues();
    }

    public Optional<Question> findQuestionById(Long id){
        List<Question> questionList = questionFakeDataBase.ShowMeMyFakeQuestionDataBaseValues();

        Optional<Question> questionIntoDB = questionList
                .stream()
                .filter(question -> question.getId().equals(id))
                .findFirst();

        return questionIntoDB;
    }
}
