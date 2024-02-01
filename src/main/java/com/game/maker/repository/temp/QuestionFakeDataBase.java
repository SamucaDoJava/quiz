package com.game.maker.repository.temp;

import com.game.maker.model.Question;
import com.game.maker.model.QuestionAlternative;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Configuration
public class QuestionFakeDataBase {

    private List<Question> question;

    @Bean(name = "questionTemporaryDataBaseInMemoryFindAll")
    public List<Question> ShowMeMyFakeQuestionDataBaseValues() {
        if (Objects.isNull(question)) {
            question = initializeQuestionList();
        }
        return new ArrayList<>(question);
    }

    @Bean
    public List<Question> initializeQuestionList(){
        List<Question> questionsList = new ArrayList<>();

        // Pergunta 1
        ArrayList<QuestionAlternative> alternativesOne = new ArrayList<>();
        alternativesOne.add(new QuestionAlternative(1L, "A", "O Senhor dos Anéis: O Retorno do Rei", true, 1L));
        alternativesOne.add(new QuestionAlternative(2L, "B", "Titanic", false, 1L));
        alternativesOne.add(new QuestionAlternative(3L, "C", "Ben-Hur", false, 1L));
        alternativesOne.add(new QuestionAlternative(4L, "D", "Gandhi", false, 1L));
        alternativesOne.add(new QuestionAlternative(5L, "E", "Avatar", false, 1L));
        alternativesOne.add(new QuestionAlternative(6L, "F", "Forrest Gump", false, 1L));
        alternativesOne.add(new QuestionAlternative(7L, "G", "Pulp Fiction", false, 1L));
        alternativesOne.add(new QuestionAlternative(8L, "H", "Gladiador", false, 1L));
        questionsList.add(new Question(1L, "Cinema", "Qual é o filme mais premiado da história do Oscar?", "O Senhor dos Anéis: O Retorno do Rei", 1L, alternativesOne));

        // Pergunta 2
        ArrayList<QuestionAlternative> alternativesTwo = new ArrayList<>();
        alternativesTwo.add(new QuestionAlternative(9L, "A", "Minecraft", true, 2L));
        alternativesTwo.add(new QuestionAlternative(10L, "B", "Tetris", false, 2L));
        alternativesTwo.add(new QuestionAlternative(11L, "C", "Super Mario Bros.", false, 2L));
        alternativesTwo.add(new QuestionAlternative(12L, "D", "Grand Theft Auto V", false, 2L));
        alternativesTwo.add(new QuestionAlternative(13L, "E", "The Legend of Zelda: Breath of the Wild", false, 2L));
        alternativesTwo.add(new QuestionAlternative(14L, "F", "FIFA 18", false, 2L));
        alternativesTwo.add(new QuestionAlternative(15L, "G", "Fortnite", false, 2L));
        alternativesTwo.add(new QuestionAlternative(16L, "H", "PlayerUnknown's Battlegrounds", false, 2L));
        questionsList.add(new Question(2L, "Jogos", "Qual é o jogo mais vendido de todos os tempos?", "Minecraft", 2L, alternativesTwo));

        // Pergunta 3
        ArrayList<QuestionAlternative> alternativesTree = new ArrayList<>();
        alternativesTree.add(new QuestionAlternative(17L, "A", "Albert Einstein", true, 3L));
        alternativesTree.add(new QuestionAlternative(18L, "B", "Isaac Newton", false, 3L));
        alternativesTree.add(new QuestionAlternative(19L, "C", "Galileo Galilei", false, 3L));
        alternativesTree.add(new QuestionAlternative(20L, "D", "Marie Curie", false, 3L));
        alternativesTree.add(new QuestionAlternative(21L, "E", "Stephen Hawking", false, 3L));
        alternativesTree.add(new QuestionAlternative(22L, "F", "Nikola Tesla", false, 3L));
        alternativesTree.add(new QuestionAlternative(23L, "G", "Thomas Edison", false, 3L));
        alternativesTree.add(new QuestionAlternative(24L, "H", "Marie Skłodowska Curie", false, 3L));
        questionsList.add(new Question(3L, "Ciência", "Quem foi o inventor da teoria da relatividade?", "Albert Einstein", 3L, alternativesTree));

        // Pergunta 4
        ArrayList<QuestionAlternative> alternativesFour = new ArrayList<>();
        alternativesFour.add(new QuestionAlternative(25L, "A", "Berlim", false, 4L));
        alternativesFour.add(new QuestionAlternative(26L, "B", "Madrid", false, 4L));
        alternativesFour.add(new QuestionAlternative(27L, "C", "Roma", false, 4L));
        alternativesFour.add(new QuestionAlternative(28L, "D", "Paris", true, 4L));
        alternativesFour.add(new QuestionAlternative(29L, "E", "Londres", false, 4L));
        alternativesFour.add(new QuestionAlternative(30L, "F", "Amsterdã", false, 4L));
        alternativesFour.add(new QuestionAlternative(31L, "G", "Atenas", false, 4L));
        alternativesFour.add(new QuestionAlternative(32L, "H", "Viena", false, 4L));
        questionsList.add(new Question(4L, "Geografia", "Qual é a capital da França?", "Paris", 28L, alternativesFour));

        // Pergunta 5
        ArrayList<QuestionAlternative> alternativesFive = new ArrayList<>();
        alternativesFive.add(new QuestionAlternative(33L, "A", "Os miseráveis", false, 5L));
        alternativesFive.add(new QuestionAlternative(34L, "B", "O Poderoso Chefão", false, 5L));
        alternativesFive.add(new QuestionAlternative(35L, "C", "12 Anos de Escravidão", false, 5L));
        alternativesFive.add(new QuestionAlternative(36L, "D", "La La Land", false, 5L));
        alternativesFive.add(new QuestionAlternative(37L, "E", "Cidadão Kane", false, 5L));
        alternativesFive.add(new QuestionAlternative(38L, "F", "Gladiador", false, 5L));
        alternativesFive.add(new QuestionAlternative(39L, "G", "Birdman", false, 5L));
        alternativesFive.add(new QuestionAlternative(40L, "H", "Parasita", true, 5L));
        questionsList.add(new Question(5L, "Cinema", "Qual filme venceu o Oscar de Melhor Filme em 2020?", "Parasita", 40L, alternativesFive));

        // Pergunta 6
        ArrayList<QuestionAlternative> alternativesSix = new ArrayList<>();
        alternativesSix.add(new QuestionAlternative(41L, "A", "Call of Duty: Modern Warfare", false, 6L));
        alternativesSix.add(new QuestionAlternative(42L, "B", "FIFA 21", false, 6L));
        alternativesSix.add(new QuestionAlternative(43L, "C", "The Legend of Zelda: Breath of the Wild", false, 6L));
        alternativesSix.add(new QuestionAlternative(44L, "D", "Fortnite", false, 6L));
        alternativesSix.add(new QuestionAlternative(45L, "E", "GTA V", false, 6L));
        alternativesSix.add(new QuestionAlternative(46L, "F", "Minecraft", false, 6L));
        alternativesSix.add(new QuestionAlternative(47L, "G", "Super Mario Bros.", false, 6L));
        alternativesSix.add(new QuestionAlternative(48L, "H", "PlayerUnknown's Battlegrounds (PUBG)", true, 6L));
        questionsList.add(new Question(6L, "Jogos", "Qual jogo é conhecido por popularizar o gênero Battle Royale?", "PlayerUnknown's Battlegrounds (PUBG)", 48L, alternativesSix));

        // Pergunta 7
        ArrayList<QuestionAlternative> alternativesSeven = new ArrayList<>();
        alternativesSeven.add(new QuestionAlternative(49L, "A", "Niels Bohr", true, 7L));
        alternativesSeven.add(new QuestionAlternative(50L, "B", "Max Planck", false, 7L));
        alternativesSeven.add(new QuestionAlternative(51L, "C", "Werner Heisenberg", false, 7L));
        alternativesSeven.add(new QuestionAlternative(52L, "D", "Marie Curie", false, 7L));
        alternativesSeven.add(new QuestionAlternative(53L, "E", "Richard Feynman", false, 7L));
        alternativesSeven.add(new QuestionAlternative(54L, "F", "Stephen Hawking", false, 7L));
        alternativesSeven.add(new QuestionAlternative(55L, "G", "Isaac Newton", false, 7L));
        alternativesSeven.add(new QuestionAlternative(56L, "H", "Albert Einstein", false, 7L));
        questionsList.add(new Question(7L, "Ciência", "Quem desenvolveu a teoria quântica?", "Niels Bohr", 49L, alternativesSeven));

        // Pergunta 8
        ArrayList<QuestionAlternative> alternativesEight = new ArrayList<>();
        alternativesEight.add(new QuestionAlternative(57L, "A", "Praga", false, 8L));
        alternativesEight.add(new QuestionAlternative(58L, "B", "Viena", false, 8L));
        alternativesEight.add(new QuestionAlternative(59L, "C", "Budapeste", true, 8L));
        alternativesEight.add(new QuestionAlternative(60L, "D", "Varsóvia", false, 8L));
        alternativesEight.add(new QuestionAlternative(61L, "E", "Atenas", false, 8L));
        alternativesEight.add(new QuestionAlternative(62L, "F", "Londres", false, 8L));
        alternativesEight.add(new QuestionAlternative(63L, "G", "Lisboa", false, 8L));
        alternativesEight.add(new QuestionAlternative(64L, "H", "Madrid", false, 8L));
        questionsList.add(new Question(8L, "Geografia", "Qual é a capital da Hungria?", "Budapeste", 59L, alternativesEight));

        // Pergunta 9
        ArrayList<QuestionAlternative> alternativesNine = new ArrayList<>();
        alternativesNine.add(new QuestionAlternative(65L, "A", "A Forca", false, 9L));
        alternativesNine.add(new QuestionAlternative(66L, "B", "Banco Imobiliário", false, 9L));
        alternativesNine.add(new QuestionAlternative(67L, "C", "Xadrez", true, 9L));
        alternativesNine.add(new QuestionAlternative(68L, "D", "Poker", false, 9L));
        alternativesNine.add(new QuestionAlternative(69L, "E", "Monopoly", false, 9L));
        alternativesNine.add(new QuestionAlternative(70L, "F", "Dominó", false, 9L));
        alternativesNine.add(new QuestionAlternative(71L, "G", "Dama", false, 9L));
        alternativesNine.add(new QuestionAlternative(72L, "H", "Cara a Cara", false, 9L));
        questionsList.add(new Question(9L, "Jogos", "Qual é o jogo de tabuleiro mais vendido de todos os tempos?", "Xadrez", 67L, alternativesNine));

        // Pergunta 10
        ArrayList<QuestionAlternative> alternativesTen = new ArrayList<>();
        alternativesTen.add(new QuestionAlternative(73L, "A", "Marie Curie", true, 10L));
        alternativesTen.add(new QuestionAlternative(74L, "B", "Nikola Tesla", false, 10L));
        alternativesTen.add(new QuestionAlternative(75L, "C", "Galileo Galilei", false, 10L));
        alternativesTen.add(new QuestionAlternative(76L, "D", "Isaac Newton", false, 10L));
        alternativesTen.add(new QuestionAlternative(77L, "E", "Max Planck", false, 10L));
        alternativesTen.add(new QuestionAlternative(78L, "F", "Werner Heisenberg", false, 10L));
        alternativesTen.add(new QuestionAlternative(79L, "G", "Niels Bohr", false, 10L));
        alternativesTen.add(new QuestionAlternative(80L, "H", "Richard Feynman", false, 10L));
        questionsList.add(new Question(10L, "Ciência", "Quem descobriu o elemento rádio?", "Marie Curie", 73L, alternativesTen));

        // Pergunta 11
        ArrayList<QuestionAlternative> alternativesEleven = new ArrayList<>();
        alternativesEleven.add(new QuestionAlternative(81L, "A", "Nova York", false, 11L));
        alternativesEleven.add(new QuestionAlternative(82L, "B", "Pequim", false, 11L));
        alternativesEleven.add(new QuestionAlternative(83L, "C", "Tóquio", false, 11L));
        alternativesEleven.add(new QuestionAlternative(84L, "D", "Moscou", false, 11L));
        alternativesEleven.add(new QuestionAlternative(85L, "E", "Cairo", false, 11L));
        alternativesEleven.add(new QuestionAlternative(86L, "F", "Londres", false, 11L));
        alternativesEleven.add(new QuestionAlternative(87L, "G", "Roma", false, 11L));
        alternativesEleven.add(new QuestionAlternative(88L, "H", "Cidade do México", true, 11L));
        questionsList.add(new Question(11L, "Geografia", "Qual é a capital do México?", "Cidade do México", 88L, alternativesEleven));

        // Pergunta 12
        ArrayList<QuestionAlternative> alternativesTwelve = new ArrayList<>();
        alternativesTwelve.add(new QuestionAlternative(89L, "A", "Dama com Arminho", false, 12L));
        alternativesTwelve.add(new QuestionAlternative(90L, "B", "O Grito", false, 12L));
        alternativesTwelve.add(new QuestionAlternative(91L, "C", "Guernica", false, 12L));
        alternativesTwelve.add(new QuestionAlternative(92L, "D", "A Noite Estrelada", false, 12L));
        alternativesTwelve.add(new QuestionAlternative(93L, "E", "Mona Lisa", false, 12L));
        alternativesTwelve.add(new QuestionAlternative(94L, "F", "Os Girassóis", false, 12L));
        alternativesTwelve.add(new QuestionAlternative(95L, "G", "O Nascimento de Vênus", false, 12L));
        alternativesTwelve.add(new QuestionAlternative(96L, "H", "Pablo Picasso", true, 12L));
        questionsList.add(new Question(12L, "Arte", "Quem pintou a obra 'Guernica'?", "Pablo Picasso", 96L, alternativesTwelve));

        return questionsList;
    }

}
