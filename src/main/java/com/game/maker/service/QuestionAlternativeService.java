package com.game.maker.service;

import com.game.maker.builder.QuestionAlternativeMapper;
import com.game.maker.dto.QuestionAlternativeDTO;
import com.game.maker.model.QuestionAlternative;
import com.game.maker.repository.temp.QuestionAlternativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class QuestionAlternativeService {
    @Autowired
    private QuestionAlternativeRepository questionAlternativeRepository;

    @Autowired
    private QuestionAlternativeMapper questionAlternativeMapper;


    public List<QuestionAlternativeDTO> findAll(){
        return questionAlternativeMapper.toListDTO(questionAlternativeRepository.findAll());
    }

    public QuestionAlternativeDTO findById(Long id){
        QuestionAlternative questionAlternative = questionAlternativeRepository.findQuestionById(id)
                .orElseThrow(() ->
                        new NoSuchElementException(
                                "Ocorreu um erro ao tentar recuperar a QuestionDTO na consulta findById"));
        return (questionAlternative != null) ? (questionAlternativeMapper.toDTO(questionAlternative)) : (null);
    }

    public List<QuestionAlternativeDTO> findByQuestionId(Long questionId){
        List<QuestionAlternative> questionAlternativeList = questionAlternativeRepository.findByQuestionId(questionId);
        return questionAlternativeMapper.toListDTO(questionAlternativeList);
    }

    public QuestionAlternativeDTO findByQuestionIdAndItsCorrect(Long questionId, Boolean alternativeStatus){
        QuestionAlternative questionAlternative = questionAlternativeRepository.findByQuestionIdAndItsCorrect(questionId, alternativeStatus)
            .orElseThrow(() ->
                new NoSuchElementException(
                        "Ocorreu um erro ao tentar recuperar a QuestionDTO"));
        return questionAlternativeMapper.toDTO(questionAlternative);
    }




}
