package com.game.maker.service;

import com.game.maker.builder.QuestionMapper;
import com.game.maker.dto.QuestionDTO;
import com.game.maker.model.Question;
import com.game.maker.repository.temp.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionMapper questionMapper;


    public List<QuestionDTO> findAll(){
        return questionMapper.toListDTO(questionRepository.findAll());
    }

    public QuestionDTO findById(Long id){
        Question question = questionRepository.findQuestionById(id)
                .orElseThrow(() ->
                        new NoSuchElementException(
                                "Ocorreu um erro ao tentar recuperar a QuestionDTO na consulta findById"));
        return (question != null) ? (questionMapper.toDTO(question)) : (null);
    }

}
