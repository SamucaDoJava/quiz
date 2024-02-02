package com.game.maker.repository.temp;

import com.game.maker.model.QuestionAlternative;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**TODO Use a mesma abordagem explicada na documentação de UserRepositoryB.class para essa classe QuestionRepository.class
 * Lembrando que quando implementarmos o banco de dados essas classes com esses comentários vão todas modificadas e muito!
 * */
@Component
public class QuestionAlternativeRepository {

    @Autowired
    private QuestionAlternativeFakeDataBase questionAlternativeFakeDataBase;

    public QuestionAlternative save(QuestionAlternative question) {
        questionAlternativeFakeDataBase.ShowMeMyFakeQuestionAlternativeDataBaseValues().add(question);
        return question;
    }

    public List<QuestionAlternative> findAll() {
        return questionAlternativeFakeDataBase.ShowMeMyFakeQuestionAlternativeDataBaseValues();
    }

    public List<QuestionAlternative> findByQuestionId(Long questionId) {
        return questionAlternativeFakeDataBase.ShowMeMyFakeQuestionAlternativeDataBaseValues().stream()
                .filter(questionAlternative -> questionAlternative.getQuestionId().equals(questionId))
                .collect(Collectors.toList());
    }

    public Optional<QuestionAlternative> findQuestionById(Long id){
        List<QuestionAlternative> questionList = questionAlternativeFakeDataBase.ShowMeMyFakeQuestionAlternativeDataBaseValues();

        Optional<QuestionAlternative> questionIntoDB = questionList
                .stream()
                .filter(question -> question.getId().equals(id))
                .findFirst();

        return questionIntoDB;
    }

    public Optional<QuestionAlternative> findByQuestionIdAndItsCorrect(Long id, Boolean alternativeStatus) {
        List<QuestionAlternative> questionList = questionAlternativeFakeDataBase.ShowMeMyFakeQuestionAlternativeDataBaseValues();

        Optional<QuestionAlternative> questionIntoDB = questionList
                .stream()
                .filter(question -> question.getId().equals(id) && question.getItsCorrect().equals(alternativeStatus))
                .findFirst();

        return questionIntoDB;
    }

}
