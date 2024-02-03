package com.game.maker.service;

import com.game.maker.builder.QuestionMapper;
import com.game.maker.dto.QuestionAlternativeDTO;
import com.game.maker.dto.QuestionDTO;
import com.game.maker.model.Question;
import com.game.maker.model.QuestionAlternative;
import com.game.maker.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public QuestionDTO save(QuestionDTO questionDTO) {
        try {
            Question questionEntity = questionRepository.save(questionMapper.toEntity(questionDTO));
            return questionMapper.toDTO(questionEntity);
        } catch (DataAccessException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Ocorreu um erro ao tentar salvar a QuestionDTO",e);
        }
    }

    //TODO Ajustar o problema dos IDs no DTO filho questionAlternative não está fazendo por default o set question, foi colocado um teste da linha 46 a 49 remover apos ajustar o DTO.
    public List<QuestionDTO> saveAll(List<QuestionDTO> questionList) {
        try {
            for(QuestionDTO questionDTO: questionList) {
                for(QuestionAlternativeDTO questionAlternative: questionDTO.getQuestionAlternativeArrayList()){
                    questionAlternative.setQuestion(questionDTO);
                }
            }

            List<Question> questionListBefore = questionMapper.toList(questionList);
            List<Question> savedAlternatives = questionRepository.saveAll(questionListBefore);

            return questionMapper.toListDTO(savedAlternatives);
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, msgError("saveAll"), e);
        }
    }

    public QuestionDTO findById(Long id){
        try {
            Question question = questionRepository.findById(id)
                    .orElseThrow(() ->
                            new NoSuchElementException(
                                    "A QuestionDTO com o ID fornecido não foi encontrada"));
            return questionMapper.toDTO(question);
        } catch (DataAccessException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Ocorreu um erro ao tentar recuperar a QuestionDTO na consulta findById", e);
        }
    }

    private String msgError(String method){
        return "Ocorreu um erro em QuestionAlternativeService ao tentar fazer a operação no método: "  + method;
    }


}
