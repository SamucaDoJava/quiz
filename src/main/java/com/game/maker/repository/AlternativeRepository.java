package com.game.maker.repository;

import com.game.maker.model.Alternative;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface AlternativeRepository extends JpaRepository<Alternative, Long> {

    List<Alternative> findByQuestionId(Long questionId);
    Optional<Alternative> findQuestionById(Long id);

    Optional<Alternative> findByQuestionIdAndItsCorrect(Long id, Boolean itsCorrect);


}
