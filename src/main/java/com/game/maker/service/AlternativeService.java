package com.game.maker.service;

import com.game.maker.builder.AlternativeMapper;
import com.game.maker.dto.AlternativeDTO;
import com.game.maker.exception.QuestionNotFoundException;
import com.game.maker.model.Alternative;
import com.game.maker.model.Question;
import com.game.maker.repository.AlternativeRepository;
import com.game.maker.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class AlternativeService {

  @Autowired
  private AlternativeRepository alternativeRepository;

  @Autowired
  private AlternativeMapper alternativeMapper;

  @Autowired
  private QuestionRepository questionRepository;

  public List<AlternativeDTO> findAll() {
    return alternativeMapper.toListDTO(alternativeRepository.findAll());
  }

  public AlternativeDTO findById(Long id) {
    Alternative alternative = alternativeRepository.findById(id)
        .orElseThrow(() ->
            new NoSuchElementException(msgError("findById")));
    return (alternative != null) ? (alternativeMapper.toDTO(alternative)) : (null);
  }

  public List<AlternativeDTO> findByIds(List<Long> ids) {
    try {
      List<Alternative> alternatives = alternativeRepository.findAllById(ids);
      return alternativeMapper.toListDTO(alternatives);
    } catch(DataAccessException e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, msgError("findByIds"), e);
    }
  }

  public AlternativeDTO save(AlternativeDTO alternativeDTO) {
    try {
      if(Objects.isNull(alternativeDTO.getQuestionId())) {
        throw new QuestionNotFoundException(msgQuestionIdNotPresent("questionId é null"));
      }

      Optional<Question> question = questionRepository.findById(alternativeDTO.getQuestionId());
      Alternative alternative = alternativeMapper.toEntity(alternativeDTO);
      question.ifPresent(value -> alternative.setQuestion(question.get()));

      Alternative savedAlternative = alternativeRepository.save(alternative);
      return alternativeMapper.toDTO(savedAlternative);

    } catch(QuestionNotFoundException e) {
      e.printStackTrace();
    } catch(Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, msgError("save"), e);
    }
    return null;
  }

  public List<AlternativeDTO> saveAll(List<AlternativeDTO> alternatives) {
    try {
      Long questionId = alternatives.stream().findFirst().map(AlternativeDTO::getQuestionId).orElse(null);

      if(Objects.isNull(questionId) || questionId <= 0) {
        throw new QuestionNotFoundException(msgQuestionIdNotPresent("id null ou menor que zero"));
      }
      Optional<Question> question = questionRepository.findById(questionId);

      if(question.isPresent()) {
        List<Alternative> alternativeList = alternativeMapper.toList(alternatives);
        alternativeList.forEach(alternative -> alternative.setQuestion(question.get()));
        List<Alternative> savedAlternatives = alternativeRepository.saveAll(alternativeList);
        return alternativeMapper.toListDTO(savedAlternatives);
      } else {
        throw new QuestionNotFoundException(msgQuestionIdNotPresent("id inexistente na base de dados."));
      }
    } catch(QuestionNotFoundException e) {
      e.printStackTrace();
    } catch(Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, msgError("saveAll"), e);
    }
    return Collections.emptyList();
  }

  public AlternativeDTO findByQuestionIdWithAlternativeCorrect(Long questionId) {
    try {
      Alternative alternative = alternativeRepository.findByQuestionIdAndItsCorrect(questionId, true)
          .orElseThrow(() ->
              new NoSuchElementException(
                  "A Alternativa com o ID de questão fornecido não foi encontrada, verifique o id da questão passado."));
      return alternativeMapper.toDTO(alternative);
    } catch(DataAccessException ex) {
      ex.getStackTrace();
      throw new ResponseStatusException(
          HttpStatus.INTERNAL_SERVER_ERROR,
          "Ocorreu um erro ao tentar recuperar a Alternativa na consulta findByQuestionIdWithAlternativeCorrect", ex);
    }
  }

  public List<AlternativeDTO> findByQuestionId(Long questionId) {
    List<Alternative> alternativeList = alternativeRepository.findByQuestionId(questionId);
    return alternativeMapper.toListDTO(alternativeList);
  }

  public AlternativeDTO findByQuestionIdAndItsCorrect(Long questionId, Boolean alternativeStatus) {
    Alternative alternative = alternativeRepository.findByQuestionIdAndItsCorrect(questionId, alternativeStatus)
        .orElseThrow(() -> new NoSuchElementException(msgError("findByQuestionIdAndItsCorrect")));
    return alternativeMapper.toDTO(alternative);
  }

  private String msgError(String method) {
    return "Ocorreu um erro em AlternativeService ao tentar fazer a operação no método: " + method;
  }

  private String msgQuestionIdNotPresent(String status) {
    return "O id da questão não foi encontrado ou é inválido, é necessário preencher o valor questionId com um id válido! Status error: " + status;
  }

}