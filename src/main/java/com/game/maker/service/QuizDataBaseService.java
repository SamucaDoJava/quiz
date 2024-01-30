package com.game.maker.service;

import com.game.maker.model.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class QuizDataBaseService {

    public ArrayList<Question> showAllQuestions(){
        ArrayList<Question> questionsList = new ArrayList<>();

        questionsList.add(new Question( "Cinema",  "Qual é o filme mais premiado da história do Oscar?",  "O Senhor dos Anéis: O Retorno do Rei"));
        questionsList.add(new Question("Jogos", "Qual é o jogo mais vendido de todos os tempos?", "Minecraft"));
        questionsList.add(new Question("Ciencia", "Quem foi o inventor da teoria da relatividade?", "Albert Einstein"));
        questionsList.add(new Question("Geografia", "Qual é a capital da França?", "Paris"));
        questionsList.add(new Question("Historia", "Em que ano ocorreu a Revolução Francesa?", "1789"));
        questionsList.add(new Question("Tecnologia", "Quem é o CEO da Tesla?", "Elon Musk"));
        questionsList.add(new Question("Literatura", "Quem escreveu 'Dom Quixote'?", "Miguel de Cervantes"));
        questionsList.add(new Question("Musica", "Qual é a banda de rock mais vendida da história?", "The Beatles"));
        questionsList.add(new Question("Esportes", "Qual é o esporte mais popular do mundo?", "Futebol"));
        questionsList.add(new Question("Arte", "Quem pintou a Mona Lisa?", "Leonardo da Vinci"));

        return questionsList;
    }

    public ArrayList<Question> findByTheme(ArrayList<Question> allQuestions, String theme){
        ArrayList<Question> filteredQuestionsList = new ArrayList<>();

        for (Question question : allQuestions) {
            if (question.getTheme().equalsIgnoreCase(theme)) {
                filteredQuestionsList.add(question);
            }
        }

        return filteredQuestionsList;
    }


}
