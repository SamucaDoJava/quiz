package com.game.maker.repository;

import com.game.maker.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query("SELECT q FROM Question q JOIN q.theme t WHERE LOWER(t.theme) LIKE LOWER(CONCAT('%', :theme, '%'))")
    List<Question> findByThemeIgnoreCase(@Param("theme") String theme);
    Optional<Question> findById(Long id);

}
