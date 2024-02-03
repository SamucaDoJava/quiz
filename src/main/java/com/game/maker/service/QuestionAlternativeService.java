package com.game.maker.service;

import com.game.maker.builder.QuestionAlternativeMapper;
import com.game.maker.dto.QuestionAlternativeDTO;
import com.game.maker.model.QuestionAlternative;
import com.game.maker.repository.QuestionAlternativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        QuestionAlternative questionAlternative = questionAlternativeRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException(msgError("findById")));
        return (questionAlternative != null) ? (questionAlternativeMapper.toDTO(questionAlternative)) : (null);
    }

    public List<QuestionAlternativeDTO> findByIds(List<Long> ids) {
        try {
            List<QuestionAlternative> questionAlternatives = questionAlternativeRepository.findAllById(ids);
            return questionAlternativeMapper.toListDTO(questionAlternatives);
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,msgError("findByIds"), e);
        }
    }

    public QuestionAlternativeDTO save(QuestionAlternative questionAlternative) {
        try {
            QuestionAlternative savedAlternative = questionAlternativeRepository.save(questionAlternative);
            return questionAlternativeMapper.toDTO(savedAlternative);
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, msgError("save"), e);
        }
    }

    public List<QuestionAlternativeDTO> saveAll(List<QuestionAlternative> questionAlternatives) {
        try {
            List<QuestionAlternative> savedAlternatives = questionAlternativeRepository.saveAll(questionAlternatives);
            return questionAlternativeMapper.toListDTO(savedAlternatives);
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, msgError("saveAll"), e);
        }
    }

    public List<QuestionAlternativeDTO> findByQuestionId(Long questionId){
        List<QuestionAlternative> questionAlternativeList = questionAlternativeRepository.findByQuestionId(questionId);
        return questionAlternativeMapper.toListDTO(questionAlternativeList);
    }

    public QuestionAlternativeDTO findByQuestionIdAndItsCorrect(Long questionId, Boolean alternativeStatus){
        QuestionAlternative questionAlternative = questionAlternativeRepository.findByQuestionIdAndItsCorrect(questionId, alternativeStatus)
            .orElseThrow(() ->
                new NoSuchElementException(msgError("findByQuestionIdAndItsCorrect")));
        return questionAlternativeMapper.toDTO(questionAlternative);
    }

    private String msgError(String method){
        return "Ocorreu um erro em QuestionAlternativeService ao tentar fazer a operação no método: "  + method;
    }


}
