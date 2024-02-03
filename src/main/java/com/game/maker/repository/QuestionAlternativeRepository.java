package com.game.maker.repository;

import com.game.maker.model.QuestionAlternative;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface QuestionAlternativeRepository extends JpaRepository<QuestionAlternative, Long> {

    List<QuestionAlternative> findByQuestionId(Long questionId);
    Optional<QuestionAlternative> findQuestionById(Long id);

    Optional<QuestionAlternative> findByQuestionIdAndItsCorrect(Long id, Boolean itsCorrect);


}
