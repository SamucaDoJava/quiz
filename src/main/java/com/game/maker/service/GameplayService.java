package com.game.maker.service;

import com.game.maker.builder.QuestionAlternativeMapper;
import com.game.maker.builder.QuestionMapper;
import com.game.maker.dto.PlayerDTO;
import com.game.maker.dto.QuestionAlternativeDTO;
import com.game.maker.dto.QuestionDTO;
import com.game.maker.dto.UserDTO;
import com.game.maker.model.Question;
import com.game.maker.repository.temp.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GameplayService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionAlternativeMapper questionAlternativeMapper;


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
        Optional<Question> optionalQuestion = questionRepository.findQuestionById(questionID);

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

    public String validateItPlayerQuestionIsCorrect(Long questionId, String selectedQuestionAlternative) {
        System.out.println("Validação da pergunta enviada pelo jogador, o Id enviado foi: " + questionId + " iremos buscar esse QuestionDTO na base de dados usando esse id.");
        System.out.println("A alternativa inserida pelo jogador foi: " + selectedQuestionAlternative + " Inicializando a busca na base de dados do objeto QuestionDTO.");

        QuestionDTO questionDTO = findPlayerQuestionByID(questionId);
        System.out.println("Busca na base de dados concluída com sucesso! O QuestionDTO encontrado tem o valor de: " + questionDTO);

        System.out.println("Iniciando a busca em QuestionDTO encontrado, iniciando validação, será verificado se QuestionDTO contém uma alternativa com a letra passada pelo usuário em selectedQuestionAlternative: "  + selectedQuestionAlternative);
        for(QuestionAlternativeDTO questionAlternativeDTO : questionDTO.getQuestionAlternativeDTOArrayList()) {
            if(questionAlternativeDTO.getAlternative().equals(selectedQuestionAlternative)) {
                System.out.println("Foi encontrada uma alternativa com a mesma letra passada pelo usuário! ");
                System.out.println("Inicializando a verificação se é uma alternativa correta! Se for, o campo itsCorrect será true.");
                if(questionAlternativeDTO.getItsCorrect()){
                    System.out.println("A alternativa passada é correta e retornou o valor de: " + true + " para o atributo itsCorrect");
                    return "Caro usuário, você acertou com sucesso a sua pergunta.";
                }
                System.out.println("A alternativa passada pelo usuário está incorreta! O usuário errou a alternativa.");
            }
        }
        return "Caro usuário, você errou a alternativa que foi passada! Tente novamente!";
    }

    public QuestionDTO findPlayerQuestionByID(Long questionID){
        System.out.println("Inicializando a busca da questão na base de dados, a questão solicitada foi a do id =" + questionID);
        return questionMapper.toDTO(
                questionRepository.findQuestionById(questionID)
                        .orElseThrow(() -> new NoSuchElementException("Pergunta não encontrada com o ID: " + questionID))
        );
    }

}
