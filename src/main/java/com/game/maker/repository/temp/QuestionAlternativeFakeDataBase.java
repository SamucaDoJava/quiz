package com.game.maker.repository.temp;

import com.game.maker.model.QuestionAlternative;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Configuration
public class QuestionAlternativeFakeDataBase {

    private List<QuestionAlternative> questionAlternatives;

    @Bean(name = "questionAlternativeTemporaryDataBaseInMemoryFindAll")
    public List<QuestionAlternative> ShowMeMyFakeQuestionAlternativeDataBaseValues() {
        if (Objects.isNull(questionAlternatives)) {
            questionAlternatives = initializeQuestionAlternativeList();
        }
        return new ArrayList<>(questionAlternatives);
    }

    @Bean
    public List<QuestionAlternative> initializeQuestionAlternativeList(){

        // Pergunta 1
        ArrayList<QuestionAlternative> alternatives = new ArrayList<>();
        alternatives.add(new QuestionAlternative(1L, "A", "O Senhor dos Anéis: O Retorno do Rei", true, 1L));
        alternatives.add(new QuestionAlternative(2L, "B", "Titanic", false, 1L));
        alternatives.add(new QuestionAlternative(3L, "C", "Ben-Hur", false, 1L));
        alternatives.add(new QuestionAlternative(4L, "D", "Gandhi", false, 1L));
        alternatives.add(new QuestionAlternative(5L, "E", "Avatar", false, 1L));
        alternatives.add(new QuestionAlternative(6L, "F", "Forrest Gump", false, 1L));
        alternatives.add(new QuestionAlternative(7L, "G", "Pulp Fiction", false, 1L));
        alternatives.add(new QuestionAlternative(8L, "H", "Gladiador", false, 1L));

        // Pergunta 2
        alternatives.add(new QuestionAlternative(9L, "A", "Minecraft", true, 2L));
        alternatives.add(new QuestionAlternative(10L, "B", "Tetris", false, 2L));
        alternatives.add(new QuestionAlternative(11L, "C", "Super Mario Bros.", false, 2L));
        alternatives.add(new QuestionAlternative(12L, "D", "Grand Theft Auto V", false, 2L));
        alternatives.add(new QuestionAlternative(13L, "E", "The Legend of Zelda: Breath of the Wild", false, 2L));
        alternatives.add(new QuestionAlternative(14L, "F", "FIFA 18", false, 2L));
        alternatives.add(new QuestionAlternative(15L, "G", "Fortnite", false, 2L));
        alternatives.add(new QuestionAlternative(16L, "H", "PlayerUnknown's Battlegrounds", false, 2L));

        // Pergunta 3
        alternatives.add(new QuestionAlternative(17L, "A", "Albert Einstein", true, 3L));
        alternatives.add(new QuestionAlternative(18L, "B", "Isaac Newton", false, 3L));
        alternatives.add(new QuestionAlternative(19L, "C", "Galileo Galilei", false, 3L));
        alternatives.add(new QuestionAlternative(20L, "D", "Marie Curie", false, 3L));
        alternatives.add(new QuestionAlternative(21L, "E", "Stephen Hawking", false, 3L));
        alternatives.add(new QuestionAlternative(22L, "F", "Nikola Tesla", false, 3L));
        alternatives.add(new QuestionAlternative(23L, "G", "Thomas Edison", false, 3L));
        alternatives.add(new QuestionAlternative(24L, "H", "Marie Skłodowska Curie", false, 3L));

        // Pergunta 4
        alternatives.add(new QuestionAlternative(25L, "A", "Berlim", false, 4L));
        alternatives.add(new QuestionAlternative(26L, "B", "Madrid", false, 4L));
        alternatives.add(new QuestionAlternative(27L, "C", "Roma", false, 4L));
        alternatives.add(new QuestionAlternative(28L, "D", "Paris", true, 4L));
        alternatives.add(new QuestionAlternative(29L, "E", "Londres", false, 4L));
        alternatives.add(new QuestionAlternative(30L, "F", "Amsterdã", false, 4L));
        alternatives.add(new QuestionAlternative(31L, "G", "Atenas", false, 4L));
        alternatives.add(new QuestionAlternative(32L, "H", "Viena", false, 4L));

        // Pergunta 5
        alternatives.add(new QuestionAlternative(33L, "A", "Os miseráveis", false, 5L));
        alternatives.add(new QuestionAlternative(34L, "B", "O Poderoso Chefão", false, 5L));
        alternatives.add(new QuestionAlternative(35L, "C", "12 Anos de Escravidão", false, 5L));
        alternatives.add(new QuestionAlternative(36L, "D", "La La Land", false, 5L));
        alternatives.add(new QuestionAlternative(37L, "E", "Cidadão Kane", false, 5L));
        alternatives.add(new QuestionAlternative(38L, "F", "Gladiador", false, 5L));
        alternatives.add(new QuestionAlternative(39L, "G", "Birdman", false, 5L));
        alternatives.add(new QuestionAlternative(40L, "H", "Parasita", true, 5L));

        // Pergunta 6
        alternatives.add(new QuestionAlternative(41L, "A", "Call of Duty: Modern Warfare", false, 6L));
        alternatives.add(new QuestionAlternative(42L, "B", "FIFA 21", false, 6L));
        alternatives.add(new QuestionAlternative(43L, "C", "The Legend of Zelda: Breath of the Wild", false, 6L));
        alternatives.add(new QuestionAlternative(44L, "D", "Fortnite", false, 6L));
        alternatives.add(new QuestionAlternative(45L, "E", "GTA V", false, 6L));
        alternatives.add(new QuestionAlternative(46L, "F", "Minecraft", false, 6L));
        alternatives.add(new QuestionAlternative(47L, "G", "Super Mario Bros.", false, 6L));
        alternatives.add(new QuestionAlternative(48L, "H", "PlayerUnknown's Battlegrounds (PUBG)", true, 6L));

        // Pergunta 7
        alternatives.add(new QuestionAlternative(49L, "A", "Niels Bohr", true, 7L));
        alternatives.add(new QuestionAlternative(50L, "B", "Max Planck", false, 7L));
        alternatives.add(new QuestionAlternative(51L, "C", "Werner Heisenberg", false, 7L));
        alternatives.add(new QuestionAlternative(52L, "D", "Marie Curie", false, 7L));
        alternatives.add(new QuestionAlternative(53L, "E", "Richard Feynman", false, 7L));
        alternatives.add(new QuestionAlternative(54L, "F", "Stephen Hawking", false, 7L));
        alternatives.add(new QuestionAlternative(55L, "G", "Isaac Newton", false, 7L));
        alternatives.add(new QuestionAlternative(56L, "H", "Albert Einstein", false, 7L));

        // Pergunta 8
        alternatives.add(new QuestionAlternative(57L, "A", "Praga", false, 8L));
        alternatives.add(new QuestionAlternative(58L, "B", "Viena", false, 8L));
        alternatives.add(new QuestionAlternative(59L, "C", "Budapeste", true, 8L));
        alternatives.add(new QuestionAlternative(60L, "D", "Varsóvia", false, 8L));
        alternatives.add(new QuestionAlternative(61L, "E", "Atenas", false, 8L));
        alternatives.add(new QuestionAlternative(62L, "F", "Londres", false, 8L));
        alternatives.add(new QuestionAlternative(63L, "G", "Lisboa", false, 8L));
        alternatives.add(new QuestionAlternative(64L, "H", "Madrid", false, 8L));

        // Pergunta 9
        alternatives.add(new QuestionAlternative(65L, "A", "A Forca", false, 9L));
        alternatives.add(new QuestionAlternative(66L, "B", "Banco Imobiliário", false, 9L));
        alternatives.add(new QuestionAlternative(67L, "C", "Xadrez", true, 9L));
        alternatives.add(new QuestionAlternative(68L, "D", "Poker", false, 9L));
        alternatives.add(new QuestionAlternative(69L, "E", "Monopoly", false, 9L));
        alternatives.add(new QuestionAlternative(70L, "F", "Dominó", false, 9L));
        alternatives.add(new QuestionAlternative(71L, "G", "Dama", false, 9L));
        alternatives.add(new QuestionAlternative(72L, "H", "Cara a Cara", false, 9L));

        // Pergunta 10
        alternatives.add(new QuestionAlternative(73L, "A", "Marie Curie", true, 10L));
        alternatives.add(new QuestionAlternative(74L, "B", "Nikola Tesla", false, 10L));
        alternatives.add(new QuestionAlternative(75L, "C", "Galileo Galilei", false, 10L));
        alternatives.add(new QuestionAlternative(76L, "D", "Isaac Newton", false, 10L));
        alternatives.add(new QuestionAlternative(77L, "E", "Max Planck", false, 10L));
        alternatives.add(new QuestionAlternative(78L, "F", "Werner Heisenberg", false, 10L));
        alternatives.add(new QuestionAlternative(79L, "G", "Niels Bohr", false, 10L));
        alternatives.add(new QuestionAlternative(80L, "H", "Richard Feynman", false, 10L));

        // Pergunta 11
        alternatives.add(new QuestionAlternative(81L, "A", "Nova York", false, 11L));
        alternatives.add(new QuestionAlternative(82L, "B", "Pequim", false, 11L));
        alternatives.add(new QuestionAlternative(83L, "C", "Tóquio", false, 11L));
        alternatives.add(new QuestionAlternative(84L, "D", "Moscou", false, 11L));
        alternatives.add(new QuestionAlternative(85L, "E", "Cairo", false, 11L));
        alternatives.add(new QuestionAlternative(86L, "F", "Londres", false, 11L));
        alternatives.add(new QuestionAlternative(87L, "G", "Roma", false, 11L));
        alternatives.add(new QuestionAlternative(88L, "H", "Cidade do México", true, 11L));

        // Pergunta 12
        alternatives.add(new QuestionAlternative(89L, "A", "Dama com Arminho", false, 12L));
        alternatives.add(new QuestionAlternative(90L, "B", "O Grito", false, 12L));
        alternatives.add(new QuestionAlternative(91L, "C", "Guernica", false, 12L));
        alternatives.add(new QuestionAlternative(92L, "D", "A Noite Estrelada", false, 12L));
        alternatives.add(new QuestionAlternative(93L, "E", "Mona Lisa", false, 12L));
        alternatives.add(new QuestionAlternative(94L, "F", "Os Girassóis", false, 12L));
        alternatives.add(new QuestionAlternative(95L, "G", "O Nascimento de Vênus", false, 12L));
        alternatives.add(new QuestionAlternative(96L, "H", "Pablo Picasso", true, 12L));

        return alternatives;
    }

}
