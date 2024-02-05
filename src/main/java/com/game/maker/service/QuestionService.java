package com.game.maker.service;

import com.game.maker.builder.QuestionMapper;
import com.game.maker.dto.QuestionDTO;
import com.game.maker.model.Question;
import com.game.maker.repository.AlternativeRepository;
import com.game.maker.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class QuestionService {

    private @Autowired QuestionRepository questionRepository;
    private @Autowired AlternativeRepository alternativeRepository;
    private @Autowired QuestionMapper questionMapper;
    public List<QuestionDTO> findAll(){
        return questionMapper.toListDTO(questionRepository.findAll());
    }


    public QuestionDTO save(QuestionDTO questionDTO) {
        try {
            Question questionEntity = questionRepository.save(questionMapper.toEntity(questionDTO));
            return questionMapper.toDTO(questionEntity);
        } catch (DataAccessException ex) {
            ex.getStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Ocorreu um erro ao tentar salvar a QuestionDTO",ex);
        }
    }

    @Transactional
    public List<QuestionDTO> saveAll(List<QuestionDTO> questionDTOList) {
        try {
            List<Question> questionsToSave = questionMapper.toList(questionDTOList);
            List<Question> savedQuestions = questionRepository.saveAll(questionsToSave);

            System.out.println("Iniciando leitura das alternativas de cada questão para em cada alternativa inserir a propria questão. Só assim o hibernate vai saber inserir os dados do id da questão em alternativa.");
            savedQuestions.forEach(question -> {
                question.getAlternativeList().forEach(alternative -> alternative.setQuestion(question));
                alternativeRepository.saveAll(question.getAlternativeList());
            });
            return questionMapper.toListDTO(savedQuestions);
        } catch (Exception ex) {
            ex.getStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, msgError("saveAll"), ex);
        }
    }

    public QuestionDTO findById(Long id){
        try {
            Question question = questionRepository.findById(id)
                    .orElseThrow(() ->
                            new NoSuchElementException(
                                    "A QuestionDTO com o ID fornecido não foi encontrada"));
            return questionMapper.toDTO(question);
        } catch (DataAccessException ex) {
            ex.getStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Ocorreu um erro ao tentar recuperar a QuestionDTO na consulta findById", ex);
        }
    }

    public List<QuestionDTO> findByTheme(String theme) {
        try {
            List<Question> questions = questionRepository.findByTheme(theme);

            if (questions.isEmpty()) {
                throw new NoSuchElementException("Nenhuma QuestionDTO encontrada para o tema: " + theme);
            }
            return questionMapper.toListDTO(questions);
        } catch (DataAccessException ex) {
            ex.printStackTrace(); // Logar a exceção de alguma maneira apropriada
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Ocorreu um erro ao tentar recuperar a QuestionDTO na consulta findByTheme", ex);
        }
    }

    private String msgError(String method){
        return "Ocorreu um erro em AlternativeService ao tentar fazer a operação no método: "  + method;
    }


}
