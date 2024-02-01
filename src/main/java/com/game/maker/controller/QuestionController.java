package com.game.maker.controller;

import com.game.maker.dto.QuestionDTO;
import com.game.maker.model.Question;
import com.game.maker.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;


    @GetMapping
    public List<QuestionDTO> findAllQuestions() {
        return questionService.findAll();
    }

    @GetMapping("/{id}")
    public QuestionDTO findById(@PathVariable Long id){
        return questionService.findById(id);
    }

}
