package com.game.maker.controller;

import com.game.maker.dto.QuestionAlternativeDTO;
import com.game.maker.dto.QuestionDTO;
import com.game.maker.model.QuestionAlternative;
import com.game.maker.service.QuestionAlternativeService;
import com.game.maker.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/question-alternative")
public class QuestionAlternativeController {

    @Autowired
    private QuestionAlternativeService questionAlternativeService;


    @GetMapping
    public List<QuestionAlternativeDTO> findAllQuestionsAlternatives() {
        return questionAlternativeService.findAll();
    }

    @GetMapping("/{id}")
    public QuestionAlternativeDTO findById(@PathVariable Long id){
        return questionAlternativeService.findById(id);
    }

    @GetMapping("/question-id/{id}")
    public List<QuestionAlternativeDTO> findQuestionAlternativesByQuestionId(@PathVariable Long id){
        return questionAlternativeService.findByQuestionId(id);
    }

    @GetMapping("/{id}/status/{alternativeStatus}")
    public QuestionAlternativeDTO findCorrectQuestionAlternativeOfQuestion(@PathVariable Long questionId, @PathVariable Boolean alternativeStatus){
        return questionAlternativeService.findByQuestionIdAndItsCorrect(questionId, alternativeStatus);
    }

}
