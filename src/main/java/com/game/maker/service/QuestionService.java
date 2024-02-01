package com.game.maker.service;

import com.game.maker.builder.QuestionMapper;
import com.game.maker.dto.QuestionDTO;
import com.game.maker.repository.temp.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionMapper questionMapper;


    public List<QuestionDTO> findAll(){
        return questionMapper.toListDTO(questionRepository.findAll());
    }

}
