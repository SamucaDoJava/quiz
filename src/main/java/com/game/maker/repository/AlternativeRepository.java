package com.game.maker.repository;

import com.game.maker.model.Alternative;
import com.game.maker.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface AlternativeRepository extends JpaRepository<Alternative, Long> {

    List<Alternative> findByQuestionId(Long questionId);
    Optional<Alternative> findQuestionById(Long id);

    Optional<Alternative> findByQuestionIdAndItsCorrect(Long questionId, Boolean itsCorrect);

}
