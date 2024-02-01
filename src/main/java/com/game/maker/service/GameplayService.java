package com.game.maker.service;

import com.game.maker.builder.PlayerMapper;
import com.game.maker.builder.QuestionAlternativeMapper;
import com.game.maker.builder.QuestionMapper;
import com.game.maker.dto.PlayerDTO;
import com.game.maker.dto.QuestionDTO;
import com.game.maker.dto.UserDTO;
import com.game.maker.model.GameplaySession;
import com.game.maker.model.Question;
import com.game.maker.model.QuestionAlternative;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class GameplayService {

    @Autowired
    private QuizDataBaseService quizDataBaseService;

    @Autowired
    private PlayerMapper playerMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionAlternativeMapper questionAlternativeMapper;

    private GameplaySession gameplaySession = new GameplaySession();


    /**Inicia a gameplay dando start o jogo Quiz para um usuário. */
    public PlayerDTO startQuizGameplay(String nickName, String theme, UserDTO userDTO) {
        PlayerDTO playerDTO = new PlayerDTO(nickName, 0, theme, userDTO);

        //No futuro pegará do banco de dados então retorna model e não dto.
        ArrayList<Question> questionsList = quizDataBaseService.showAllQuestions();
        ArrayList<Question> filteredQuestionsList = quizDataBaseService.findByTheme(questionsList, playerDTO.getTheme());

        playerDTO.setPlayerQuestionsDTOList(questionMapper.toListDTO(filteredQuestionsList));
        return playerDTO;
    }

    /** Valida se a resposta colocada pelo Player está correta, se sim! Remove a pergunta
     * para que o usuário não possa ter a mesma pergunta repetida novamente.*/
    public PlayerDTO validateItPlayerQuestionIsCorrect(PlayerDTO playerDTO) {
        System.out.println("Quantidade atual de perguntas no quiz para o playerDTO: " + playerDTO.getPlayerQuestionsDTOList().size());
        System.out.println("Usando o tema: " + playerDTO.getTheme());

        Long playerSelectedQuestionID = playerDTO.getCurrentQuestionID();

        //Recuperando dados em suposto banco de dados que ainda está em memória.
        Question currentPlayerQuestion = quizDataBaseService.findQuestionById(playerSelectedQuestionID);
        //Adicionando a questão recuperada em banco de dados dentro do objeto currentPlayerQuestion do userDTO.
        QuestionDTO questionDTO = questionMapper.toDTO(currentPlayerQuestion);
        playerDTO.setCurrentPlayerQuestionDTO(questionDTO);

        //Recuperando na base de dados todas as Questions por tema.
        List<Question> allPlayerQuestionsByTheme = quizDataBaseService.findByTheme(playerDTO.getTheme());

        Iterator<QuestionDTO> questionsIntoPlayerIterator = questionMapper.toListDTO(allPlayerQuestionsByTheme).iterator();

        while (questionsIntoPlayerIterator.hasNext()) {
            QuestionDTO currentQuestionIntoIterator = questionsIntoPlayerIterator.next();
            Long questionsIntoPlayerIteratorId = currentQuestionIntoIterator.getId();

            //
            if (playerSelectedQuestionID.equals(questionsIntoPlayerIteratorId)) {
                System.out.println("Encontramos o mesmo id em playerSelectedQuestionID........= " + playerSelectedQuestionID);
                System.out.println("E encontramos o mesmo id em questionsIntoPlayerIteratorId = " + questionsIntoPlayerIteratorId);

                // Recuperamos a partir da Question atual a lista das alternativas da Question.
                ArrayList<QuestionAlternative> currentSelectedQuestionAlternativeList = quizDataBaseService.findQuestionAlternativesByQuestionId(playerSelectedQuestionID);

                System.out.println("Achamos as seguintes anternativas: " + currentSelectedQuestionAlternativeList);
                System.out.println("Quantidade de anternativas: " + currentSelectedQuestionAlternativeList.size());

                //Inserindo lista de alternativas na atual Question do Player
                playerDTO.getCurrentPlayerQuestionDTO().setQuestionAlternativeDTOArrayList(questionAlternativeMapper.toListDTO(currentSelectedQuestionAlternativeList));

                System.out.println("Nosso player agora tem uma question e alternativas: " + playerDTO);

                if(playerDTO.getSelectedQuestionAlternative().getItsCorrect()) {
                    //Insere Score se a alternativa estiver correta;
                    playerDTO.setScore(playerDTO.getScore() + 100);
                }
            }
        }
        return playerDTO;
    }

    /** Adiciona o usuário a sessão de jogo, a ideia é usar esse dados para criar outros
     * jogos com vários jogadores na mesma sessão filtrados por tema. */
    public GameplaySession addPlayerToSession(PlayerDTO playerDTO){
        gameplaySession.getPlayerDTOList().add(playerDTO);
        return gameplaySession;
    }

    /** Chama a sessão atual do jogo*/
    public GameplaySession getCurrentSession(){
        return gameplaySession;
    }

    /** Procura dentro do usuário uma unica Questão do quiz. */
    public QuestionDTO findPlayerQuestionByID(PlayerDTO playerDTO, Long questionID){
        List<QuestionDTO> questionDTOList = playerDTO.getPlayerQuestionsDTOList();
        for(QuestionDTO questionDTO:questionDTOList){
            if(questionID.equals(questionDTO.getId())){
                return questionDTO;
            }
        }
        return null;
    }

    public QuestionDTO findPlayerQuestionAndAlternativesByQuestionId(Long questionID){
        QuestionDTO questionDTO = questionMapper.toDTO(quizDataBaseService.findQuestionById(questionID));

        ArrayList<QuestionAlternative> questionAlternativesList = quizDataBaseService.findQuestionAlternativesByQuestionId(questionID);
        questionDTO.setQuestionAlternativeDTOArrayList(questionAlternativeMapper.toListDTO(questionAlternativesList));
        return questionDTO;
    }

}
