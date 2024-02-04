package com.game.maker.service;

import com.game.maker.builder.AlternativeMapper;
import com.game.maker.builder.QuestionMapper;
import com.game.maker.dto.PlayerDTO;
import com.game.maker.dto.QuestionDTO;
import com.game.maker.dto.UserDTO;
import com.game.maker.model.Question;
import com.game.maker.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

@Service
public class GameplayService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private AlternativeMapper alternativeMapper;


    /**Inicia a gameplay dando start o jogo Quiz para um usuário. */
    public PlayerDTO startQuizGameplay(String nickName, String theme, UserDTO userDTO) {
        PlayerDTO playerDTO = new PlayerDTO(nickName, 0, theme, userDTO);

        System.out.println("Inicializando a busca na base de dados das questões com o tema: " + theme);
        List<Question> filteredQuestionsList = questionRepository.findByTheme(playerDTO.getTheme());

        System.out.println("Foram encontrados " + filteredQuestionsList.size() + " questões na base de dados para o tema: " + theme);
        playerDTO.setPlayerQuestionsDTOList(questionMapper.toListDTO(filteredQuestionsList));
        return playerDTO;
    }

    public QuestionDTO findPlayerQuestionAndAlternativesByQuestionId(Long questionID){
        return findQuestionByIdAndValidate(questionID);
    }

    private QuestionDTO findQuestionByIdAndValidate(Long questionID){
        System.out.println("Iniciando busca na base de dados por uma questão com o Id: " + questionID);
        Optional<Question> optionalQuestion = questionRepository.findById(questionID);

        if (optionalQuestion.isPresent()) {
            System.out.println("Foi encontrada uma questão com o id: " + questionID + " inicializando serialização, transformando Question em QuestionDTO");
            QuestionDTO questionDTO = questionMapper.toDTO(optionalQuestion.get());
            System.out.println("Question foi transformado em QuestionDTO com sucesso! questionDTO = " + questionDTO);

            return questionDTO;
        } else {
            System.out.println("Não foi encontrado nada com o Id passado dentro da base de dados!");
            return null;
        }
    }

    public QuestionDTO generateQuestion(){
        List<Question> questionList = questionRepository.findAll();

        if (questionList.isEmpty()) {
            return null;
        }

        // Use Random para gerar um índice aleatório dentro dos limites da lista
        Random random = new Random();
        int randomIndex = random.nextInt(questionList.size());

        Question randomQuestion = questionList.get(randomIndex);
        QuestionDTO randomQuestionDTO = questionMapper.toDTO(randomQuestion);

        return randomQuestionDTO;
    }

    public QuestionDTO findPlayerQuestionByID(Long questionID){
        System.out.println("Inicializando a busca da questão na base de dados, a questão solicitada foi a do id =" + questionID);

        Question questionIntoDB = questionRepository.findById(questionID).
                orElseThrow(() -> new NoSuchElementException("Pergunta não encontrada com Id: " + questionID));

        return (questionIntoDB != null) ? (questionMapper.toDTO(questionIntoDB)) : (null);
    }

}
