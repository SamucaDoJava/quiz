package com.game.maker.service;

import com.game.maker.builder.PlayerGameplaySessionValuesMapper;
import com.game.maker.dto.PlayerGameplaySessionValuesDTO;
import com.game.maker.model.PlayerGameplaySessionValues;
import com.game.maker.repository.PlayerGameplaySessionValuesRepository;
import com.game.maker.repository.QuestionRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PlayerGameplaySessionValuesService {

    private final Logger LOGGER = LogManager.getLogger(PlayerGameplaySessionValuesService.class);

    @Autowired
    private PlayerGameplaySessionValuesRepository playerGameplaySessionValuesRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private PlayerGameplaySessionValuesMapper playerGameplaySessionValuesMapper;




    public List<PlayerGameplaySessionValuesDTO> findAll() {
        return playerGameplaySessionValuesMapper.toListDTO(playerGameplaySessionValuesRepository.findAll());
    }

    public PlayerGameplaySessionValuesDTO save(PlayerGameplaySessionValuesDTO playerGameplaySessionValuesDTO) {
        PlayerGameplaySessionValues playerGameplaySessionQuestion = playerGameplaySessionValuesMapper.toEntity(playerGameplaySessionValuesDTO);
        return playerGameplaySessionValuesMapper.toDTO(save(playerGameplaySessionQuestion));
    }

    public PlayerGameplaySessionValues save(PlayerGameplaySessionValues playerGameplaySessionValues) {
        try {
            return playerGameplaySessionValuesRepository.save(playerGameplaySessionValues);
        } catch (DataAccessException ex) {
            LOGGER.error("Ocorreu um erro no método save, erro: ", ex);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Ocorreu um erro ao tentar salvar a PlayerGameplaySessionValuesDTO", ex);
        }
    }

    @Transactional
    public List<PlayerGameplaySessionValuesDTO> saveAll(List<PlayerGameplaySessionValuesDTO> playerGameplaySessionValuesDTOList) {
        try {
            List<PlayerGameplaySessionValues> playerGameplaySessionValuesToSave = playerGameplaySessionValuesMapper.toList(playerGameplaySessionValuesDTOList);
            List<PlayerGameplaySessionValues> savedPlayerGameplaySessionValues = playerGameplaySessionValuesRepository.saveAll(playerGameplaySessionValuesToSave);

            return playerGameplaySessionValuesMapper.toListDTO(savedPlayerGameplaySessionValues);
        } catch (Exception ex) {
            LOGGER.error("Ocorreu um erro no método saveAll, erro: ", ex);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, msgError("saveAll"), ex);
        }
    }

    public PlayerGameplaySessionValuesDTO findById(Long id) {
        try {
            PlayerGameplaySessionValues playerGameplaySessionValues = playerGameplaySessionValuesRepository.findById(id)
                    .orElseThrow(() ->
                            new NoSuchElementException(
                                    "A PlayerGameplaySessionValuesDTO com o ID fornecido não foi encontrada"));
            return playerGameplaySessionValuesMapper.toDTO(playerGameplaySessionValues);
        } catch (DataAccessException ex) {
            LOGGER.error("Ocorreu um erro no método findById, erro: ", ex);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Ocorreu um erro ao tentar recuperar a PlayerGameplaySessionValuesDTO na consulta findById", ex);
        }
    }

    private String msgError(String method) {
        return "Ocorreu um erro em PlayerGameplaySessionValuesService ao tentar fazer a operação no método: " + method;
    }

}
