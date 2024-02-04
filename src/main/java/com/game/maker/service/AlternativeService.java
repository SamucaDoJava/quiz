package com.game.maker.service;

import com.game.maker.builder.AlternativeMapper;
import com.game.maker.dto.AlternativeDTO;
import com.game.maker.model.Alternative;
import com.game.maker.repository.AlternativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AlternativeService {
    @Autowired
    private AlternativeRepository alternativeRepository;

    @Autowired
    private AlternativeMapper alternativeMapper;


    public List<AlternativeDTO> findAll(){
        return alternativeMapper.toListDTO(alternativeRepository.findAll());
    }

    public AlternativeDTO findById(Long id){
        Alternative alternative = alternativeRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException(msgError("findById")));
        return (alternative != null) ? (alternativeMapper.toDTO(alternative)) : (null);
    }

    public List<AlternativeDTO> findByIds(List<Long> ids) {
        try {
            List<Alternative> alternatives = alternativeRepository.findAllById(ids);
            return alternativeMapper.toListDTO(alternatives);
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,msgError("findByIds"), e);
        }
    }

    public AlternativeDTO save(Alternative alternative) {
        try {
            Alternative savedAlternative = alternativeRepository.save(alternative);
            return alternativeMapper.toDTO(savedAlternative);
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, msgError("save"), e);
        }
    }

    public List<AlternativeDTO> saveAll(List<Alternative> alternatives) {
        try {
            List<Alternative> savedAlternatives = alternativeRepository.saveAll(alternatives);
            return alternativeMapper.toListDTO(savedAlternatives);
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, msgError("saveAll"), e);
        }
    }

    public List<AlternativeDTO> findByQuestionId(Long questionId){
        List<Alternative> alternativeList = alternativeRepository.findByQuestionId(questionId);
        return alternativeMapper.toListDTO(alternativeList);
    }

    public AlternativeDTO findByQuestionIdAndItsCorrect(Long questionId, Boolean alternativeStatus){
        Alternative alternative = alternativeRepository.findByQuestionIdAndItsCorrect(questionId, alternativeStatus)
            .orElseThrow(() ->
                new NoSuchElementException(msgError("findByQuestionIdAndItsCorrect")));
        return alternativeMapper.toDTO(alternative);
    }

    private String msgError(String method){
        return "Ocorreu um erro em AlternativeService ao tentar fazer a operação no método: "  + method;
    }


}
