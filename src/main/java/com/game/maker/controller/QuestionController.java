package com.game.maker.controller;

import com.game.maker.dto.QuestionAlternativeDTO;
import com.game.maker.dto.QuestionDTO;
import com.game.maker.model.Question;
import com.game.maker.model.QuestionAlternative;
import com.game.maker.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/save")
    public QuestionDTO save(@RequestBody QuestionDTO questionDTO){
        return questionService.save(questionDTO);
    }

    @GetMapping("/{id}")
    public QuestionDTO findById(@PathVariable Long id){
        return questionService.findById(id);
    }

    @PostMapping("save/list")
    public List<QuestionDTO> save(@RequestBody List<QuestionDTO> questionDTOList){
        return questionService.saveAll(questionDTOList);
    }

    @GetMapping
    public List<QuestionDTO> findAllQuestions() {
        return questionService.findAll();
    }

}
