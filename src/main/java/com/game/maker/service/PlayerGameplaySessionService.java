package com.game.maker.service;

import com.game.maker.builder.PlayerGameplaySessionMapper;
import com.game.maker.dto.PlayerGameplaySessionDTO;
import com.game.maker.model.PlayerGameplaySession;
import com.game.maker.repository.PlayerGameplaySessionRepository;
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
public class PlayerGameplaySessionService {

    private final Logger LOGGER = LogManager.getLogger(PlayerGameplaySessionService.class);

    @Autowired
    private PlayerGameplaySessionRepository playerGameplaySessionRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private PlayerGameplaySessionMapper playerGameplaySessionMapper;




    public List<PlayerGameplaySessionDTO> findAll() {
        return playerGameplaySessionMapper.toListDTO(playerGameplaySessionRepository.findAll());
    }

    public PlayerGameplaySessionDTO save(PlayerGameplaySessionDTO playerGameplaySessionDTO) {
        PlayerGameplaySession playerGameplaySessionQuestion = playerGameplaySessionMapper.toEntity(playerGameplaySessionDTO);
        return playerGameplaySessionMapper.toDTO(save(playerGameplaySessionQuestion));
    }

    public PlayerGameplaySession save(PlayerGameplaySession playerGameplaySession) {
        try {
            return playerGameplaySessionRepository.save(playerGameplaySession);
        } catch (DataAccessException ex) {
            LOGGER.error("Ocorreu um erro no método save, erro: ", ex);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Ocorreu um erro ao tentar salvar a PlayerGameplaySessionDTO", ex);
        }
    }

    @Transactional
    public List<PlayerGameplaySessionDTO> saveAll(List<PlayerGameplaySessionDTO> playerGameplaySessionDTOList) {
        try {
            List<PlayerGameplaySession> playerGameplaySessionToSave = playerGameplaySessionMapper.toList(playerGameplaySessionDTOList);
            List<PlayerGameplaySession> savedPlayerGameplaySessionValues = playerGameplaySessionRepository.saveAll(playerGameplaySessionToSave);

            return playerGameplaySessionMapper.toListDTO(savedPlayerGameplaySessionValues);
        } catch (Exception ex) {
            LOGGER.error("Ocorreu um erro no método saveAll, erro: ", ex);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, msgError("saveAll"), ex);
        }
    }

    public PlayerGameplaySessionDTO findById(Long id) {
        try {
            PlayerGameplaySession playerGameplaySession = playerGameplaySessionRepository.findById(id)
                    .orElseThrow(() ->
                            new NoSuchElementException(
                                    "A PlayerGameplaySessionDTO com o ID fornecido não foi encontrada"));
            return playerGameplaySessionMapper.toDTO(playerGameplaySession);
        } catch (DataAccessException ex) {
            LOGGER.error("Ocorreu um erro no método findById, erro: ", ex);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Ocorreu um erro ao tentar recuperar a PlayerGameplaySessionDTO na consulta findById", ex);
        }
    }

    private String msgError(String method) {
        return "Ocorreu um erro em PlayerGameplaySessionService ao tentar fazer a operação no método: " + method;
    }

}
