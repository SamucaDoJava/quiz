package com.game.maker.controller;

import com.game.maker.dto.QuestionAlternativeDTO;
import com.game.maker.dto.ValidateAlternativeDTO;
import com.game.maker.model.QuestionAlternative;
import com.game.maker.service.QuestionAlternativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("save")
    public QuestionAlternativeDTO save(@RequestBody QuestionAlternative questionAlternative){
        return questionAlternativeService.save(questionAlternative);
    }

    @PostMapping("save/list")
    public List<QuestionAlternativeDTO> save(@RequestBody List<QuestionAlternative> questionAlternativeList){
        return questionAlternativeService.saveAll(questionAlternativeList);
    }

    @GetMapping("/question-id/{id}")
    public List<QuestionAlternativeDTO> findQuestionAlternativesByQuestionId(@PathVariable Long id){
        return questionAlternativeService.findByQuestionId(id);
    }

    @PostMapping("/validate-alternative")
    public QuestionAlternativeDTO validateAlternative(ValidateAlternativeDTO validateAlternativeDTO){
        return questionAlternativeService.findByQuestionIdAndItsCorrect(validateAlternativeDTO.getId(), validateAlternativeDTO.getAlternativeStatus());
    }

}
