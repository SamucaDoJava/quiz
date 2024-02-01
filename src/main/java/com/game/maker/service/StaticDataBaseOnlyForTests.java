package com.game.maker.service;

import com.game.maker.model.Question;
import com.game.maker.model.QuestionAlternative;
import com.game.maker.model.User;

import java.util.ArrayList;

public class StaticDataBaseOnlyForTests {

    public static ArrayList<Question> staticDataBaseWithHardcode(){
        ArrayList<Question> questionsList = new ArrayList<>();

        // Pergunta 1
        ArrayList<QuestionAlternative> alternativesOne = new ArrayList<>();
        alternativesOne.add(new QuestionAlternative(1L,"A","O Senhor dos Anéis: O Retorno do Rei", true));
        alternativesOne.add(new QuestionAlternative(2L,"B", "Titanic", false));
        alternativesOne.add(new QuestionAlternative(3L,"C", "Ben-Hur", false));
        alternativesOne.add(new QuestionAlternative(4L,"D","Gandhi", false));
        alternativesOne.add(new QuestionAlternative(5L,"E","Avatar", false));
        alternativesOne.add(new QuestionAlternative(6L,"F","Forrest Gump", false));
        alternativesOne.add(new QuestionAlternative(7L,"G","Pulp Fiction", false));
        alternativesOne.add(new QuestionAlternative(8L,"H","Gladiador", false));
        questionsList.add(new Question(1L, "Cinema", "Qual é o filme mais premiado da história do Oscar?", "O Senhor dos Anéis: O Retorno do Rei", 1L, alternativesOne));

        // Pergunta 2
        ArrayList<QuestionAlternative> alternativesTwo = new ArrayList<>();
        alternativesTwo.add(new QuestionAlternative(9L,"A","Minecraft", true));
        alternativesTwo.add(new QuestionAlternative(10L,"B","Tetris", false));
        alternativesTwo.add(new QuestionAlternative(11L,"C","Super Mario Bros.", false));
        alternativesTwo.add(new QuestionAlternative(12L,"D","Grand Theft Auto V", false));
        alternativesTwo.add(new QuestionAlternative(13L,"E","The Legend of Zelda: Breath of the Wild", false));
        alternativesTwo.add(new QuestionAlternative(14L,"F","FIFA 18", false));
        alternativesTwo.add(new QuestionAlternative(15L,"G","Fortnite", false));
        alternativesTwo.add(new QuestionAlternative(16L,"H","PlayerUnknown's Battlegrounds", false));
        questionsList.add(new Question(2L,"Jogos", "Qual é o jogo mais vendido de todos os tempos?", "Minecraft", 9L, alternativesTwo));

        // Pergunta 3
        ArrayList<QuestionAlternative> alternativesTree = new ArrayList<>();
        alternativesTree.add(new QuestionAlternative(17L,"A","Albert Einstein", true));
        alternativesTree.add(new QuestionAlternative(18L,"B","Isaac Newton", false));
        alternativesTree.add(new QuestionAlternative(19L,"C","Galileo Galilei", false));
        alternativesTree.add(new QuestionAlternative(20L,"D","Marie Curie", false));
        alternativesTree.add(new QuestionAlternative(21L,"E","Stephen Hawking", false));
        alternativesTree.add(new QuestionAlternative(22L,"F","Nikola Tesla", false));
        alternativesTree.add(new QuestionAlternative(23L,"G", "Thomas Edison", false));
        alternativesTree.add(new QuestionAlternative(24L,"H", "Marie Skłodowska Curie", false));
        questionsList.add(new Question(3L,"Ciência", "Quem foi o inventor da teoria da relatividade?", "Albert Einstein", 17L, alternativesTree));

        // Pergunta 4
        ArrayList<QuestionAlternative> alternativesFour = new ArrayList<>();
        alternativesFour.add(new QuestionAlternative(25L,"A", "Berlim", false));
        alternativesFour.add(new QuestionAlternative(26L,"B","Madrid", false));
        alternativesFour.add(new QuestionAlternative(27L,"C","Roma", false));
        alternativesFour.add(new QuestionAlternative(28L,"D","Paris", true));
        alternativesFour.add(new QuestionAlternative(29L,"E","Londres", false));
        alternativesFour.add(new QuestionAlternative(30L,"F","Amsterdã", false));
        alternativesFour.add(new QuestionAlternative(31L,"G","Atenas", false));
        alternativesFour.add(new QuestionAlternative(32L,"H","Viena", false));
        questionsList.add(new Question(4L,"Geografia", "Qual é a capital da França?", "Paris", 28L, alternativesFour));

        // Pergunta 5
        ArrayList<QuestionAlternative> alternativesFive = new ArrayList<>();
        alternativesFive.add(new QuestionAlternative(33L,"A", "Os miseráveis", false));
        alternativesFive.add(new QuestionAlternative(34L,"B","O Poderoso Chefão", false));
        alternativesFive.add(new QuestionAlternative(35L,"C","12 Anos de Escravidão", false));
        alternativesFive.add(new QuestionAlternative(36L,"D","La La Land", false));
        alternativesFive.add(new QuestionAlternative(37L,"E","Cidadão Kane", false));
        alternativesFive.add(new QuestionAlternative(38L,"F","Gladiador", false));
        alternativesFive.add(new QuestionAlternative(39L,"G","Birdman", false));
        alternativesFive.add(new QuestionAlternative(40L,"H","Parasita", true));
        questionsList.add(new Question(5L,"Cinema", "Qual filme venceu o Oscar de Melhor Filme em 2020?", "Parasita", 40L, alternativesFive));

        // Pergunta 6
        ArrayList<QuestionAlternative> alternativesSix = new ArrayList<>();
        alternativesSix.add(new QuestionAlternative(41L,"A","Call of Duty: Modern Warfare", false));
        alternativesSix.add(new QuestionAlternative(42L,"B","FIFA 21", false));
        alternativesSix.add(new QuestionAlternative(43L,"C","The Legend of Zelda: Breath of the Wild", false));
        alternativesSix.add(new QuestionAlternative(44L,"D","Fortnite", false));
        alternativesSix.add(new QuestionAlternative(45L,"E","GTA V", false));
        alternativesSix.add(new QuestionAlternative(46L,"F","Minecraft", false));
        alternativesSix.add(new QuestionAlternative(47L,"G","Super Mario Bros.", false));
        alternativesSix.add(new QuestionAlternative(48L,"H","PlayerUnknown's Battlegrounds (PUBG)", true));
        questionsList.add(new Question(6L,"Jogos", "Qual jogo é conhecido por popularizar o gênero Battle Royale?", "PlayerUnknown's Battlegrounds (PUBG)", 48L, alternativesSix));

        // Pergunta 7
        ArrayList<QuestionAlternative> alternativesSeven = new ArrayList<>();
        alternativesSeven.add(new QuestionAlternative(49L,"A","Niels Bohr", true));
        alternativesSeven.add(new QuestionAlternative(50L,"B","Max Planck", false));
        alternativesSeven.add(new QuestionAlternative(51L,"C","Werner Heisenberg", false));
        alternativesSeven.add(new QuestionAlternative(52L,"D","Marie Curie", false));
        alternativesSeven.add(new QuestionAlternative(53L,"E","Richard Feynman", false));
        alternativesSeven.add(new QuestionAlternative(54L,"F","Stephen Hawking", false));
        alternativesSeven.add(new QuestionAlternative(55L,"G","Isaac Newton", false));
        alternativesSeven.add(new QuestionAlternative(56L,"H","Albert Einstein", false));
        questionsList.add(new Question(7L,"Ciência", "Quem desenvolveu a teoria quântica?", "Niels Bohr", 49L, alternativesSeven));

        // Pergunta 8
        ArrayList<QuestionAlternative> alternativesEight = new ArrayList<>();
        alternativesEight.add(new QuestionAlternative(57L,"A","Praga", false));
        alternativesEight.add(new QuestionAlternative(58L,"B","Viena", false));
        alternativesEight.add(new QuestionAlternative(59L,"C","Budapeste", true));
        alternativesEight.add(new QuestionAlternative(60L,"D","Varsóvia", false));
        alternativesEight.add(new QuestionAlternative(61L,"E","Atenas", false));
        alternativesEight.add(new QuestionAlternative(62L,"F","Londres", false));
        alternativesEight.add(new QuestionAlternative(63L,"G","Lisboa", false));
        alternativesEight.add(new QuestionAlternative(64L,"H","Madrid", false));
        questionsList.add(new Question(8L,"Geografia", "Qual é a capital da Hungria?", "Budapeste", 59L, alternativesEight));

        // Pergunta 9
        ArrayList<QuestionAlternative> alternativesNine = new ArrayList<>();
        alternativesNine.add(new QuestionAlternative(65L,"A","A Forca", false));
        alternativesNine.add(new QuestionAlternative(66L,"B","Banco Imobiliário", false));
        alternativesNine.add(new QuestionAlternative(67L,"C","Xadrez", true));
        alternativesNine.add(new QuestionAlternative(68L,"D","Poker", false));
        alternativesNine.add(new QuestionAlternative(69L,"E","Monopoly", false));
        alternativesNine.add(new QuestionAlternative(70L,"F","Dominó", false));
        alternativesNine.add(new QuestionAlternative(71L,"G","Dama", false));
        alternativesNine.add(new QuestionAlternative(72L,"H","Cara a Cara", false));
        questionsList.add(new Question(9L,"Jogos", "Qual é o jogo de tabuleiro mais vendido de todos os tempos?", "Xadrez", 67L, alternativesNine));

        // Pergunta 10
        ArrayList<QuestionAlternative> alternativesTen = new ArrayList<>();
        alternativesTen.add(new QuestionAlternative(73L,"A","Marie Curie", true));
        alternativesTen.add(new QuestionAlternative(74L,"B","Nikola Tesla", false));
        alternativesTen.add(new QuestionAlternative(75L,"C","Galileo Galilei", false));
        alternativesTen.add(new QuestionAlternative(76L,"D","Isaac Newton", false));
        alternativesTen.add(new QuestionAlternative(77L,"E","Max Planck", false));
        alternativesTen.add(new QuestionAlternative(78L,"F","Werner Heisenberg", false));
        alternativesTen.add(new QuestionAlternative(79L,"G","Niels Bohr", false));
        alternativesTen.add(new QuestionAlternative(80L,"H","Richard Feynman", false));
        questionsList.add(new Question(10L,"Ciência", "Quem descobriu o elemento rádio?", "Marie Curie", 73L, alternativesTen));

        // Pergunta 11
        ArrayList<QuestionAlternative> alternativesEleven = new ArrayList<>();
        alternativesEleven.add(new QuestionAlternative(81L,"A","Nova York", false));
        alternativesEleven.add(new QuestionAlternative(82L,"B","Pequim", false));
        alternativesEleven.add(new QuestionAlternative(83L,"C","Tóquio", false));
        alternativesEleven.add(new QuestionAlternative(84L,"D","Moscou", false));
        alternativesEleven.add(new QuestionAlternative(85L,"E","Cairo", false));
        alternativesEleven.add(new QuestionAlternative(86L,"F","Londres", false));
        alternativesEleven.add(new QuestionAlternative(87L,"G","Roma", false));
        alternativesEleven.add(new QuestionAlternative(88L,"H","Cidade do México", true));
        questionsList.add(new Question(11L,"Geografia", "Qual é a capital do México?", "Cidade do México", 88L, alternativesEleven));

        // Pergunta 12
        ArrayList<QuestionAlternative> alternativesTwelve = new ArrayList<>();
        alternativesTwelve.add(new QuestionAlternative(89L,"A","Dama com Arminho", false));
        alternativesTwelve.add(new QuestionAlternative(90L,"B","O Grito", false));
        alternativesTwelve.add(new QuestionAlternative(91L,"C","Guernica", false));
        alternativesTwelve.add(new QuestionAlternative(92L,"D","A Noite Estrelada", false));
        alternativesTwelve.add(new QuestionAlternative(93L,"E","Mona Lisa", false));
        alternativesTwelve.add(new QuestionAlternative(94L,"F","Os Girassóis", false));
        alternativesTwelve.add(new QuestionAlternative(95L,"G","O Nascimento de Vênus", false));
        alternativesTwelve.add(new QuestionAlternative(96L,"H","Pablo Picasso", true));
        questionsList.add(new Question(12L,"Arte", "Quem pintou a obra 'Guernica'?", "Pablo Picasso", 96L, alternativesTwelve));

        return questionsList;
    }

    public static ArrayList<User> staticUserDataBase(){
        ArrayList<User> userList = new ArrayList<>();

        // Preenchendo o ArrayList com 10 instâncias de User
        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setId((long) i);
            user.setName("User" + i);
            user.setFullName("Full Name" + i);
            user.setAge(20 + i);
            user.setEmail("user" + i + "@example.com");
            user.setPassword("password" + i);

            userList.add(user);
        }

        // Imprimindo os usuários no ArrayList
        for (User user : userList) {
            System.out.println(user);
        }
        return userList;
    }

    public static ArrayList<User> staticUserDataBaseMjv(){
        ArrayList<User> userList = new ArrayList<>();

        String[] nomes = {
                "Alunos",
                "Abelardo Carvalho",
                "Ademir Monteiro da Silva Filho",
                "Adriano Donizette Ferreira",
                "Caio Tosta Pedreira",
                "Caio Vinicius Nogueira Magalhães de Sousa Melo",
                "Danielly Cardoso de Andrade Oliveira",
                "Dhionson Plaster Moreira",
                "Diego Lopes da Silva",
                "Ednaldo Luiz",
                "Elton Henrique",
                "Fernando Castelo Branco",
                "Filipe Castro",
                "Gabriel Marinho",
                "Gilberto Pereira do Nascimento Júnior",
                "Gleydson Galvão Celerino",
                "Guilherme Aparecido Giordano Ribeiro",
                "Guilherme Morais",
                "Gustavo Lima Rocha de Sousa",
                "Hebert Ferreira Soares",
                "Hugo Emanuel Alves de Freitas",
                "Irlan Suzano Marcillino",
                "Jéssica dos Santos Paiva",
                "João Gabriel",
                "João Victor Guilherme Bezerra de Menezes",
                "Juan Benedito",
                "Júlia Menger",
                "Kennedy Klaydm da Silva Cavalcanti",
                "Larissa Perdigão",
                "Leo Ramos Matias",
                "Lia Dobbiss",
                "Lucas Freitas de Bastos",
                "Lucas Lopes Chaves",
                "Lucas Vinicius Vieira Calado",
                "Matheus Enrico da SIlva",
                "Naara Nunes de Melo Marinheiro",
                "Nathalia Terribile do Nascimento",
                "Paula Pedrosa",
                "Paulo Henrique Mendes Paiva",
                "Pedro Krassuski",
                "Richard Alexandrino de Macedo",
                "Roberdan Tamyr dos Santos Feitosa Junior",
                "Robson Júlio Corrêa da Silva",
                "Rodolfo Rodrigues Silva",
                "Rodrigo Nascimento",
                "Rodrigo Xavier dos Santos",
                "Ronald Vale",
                "Sara Cristina Brasileiro Sales",
                "Saulo Henrique Rodrigues",
                "Thallys Cézar de Oliveira Alves Pequeno",
                "Thayna Pacheco",
                "Thiago Alves",
                "Valdomiro Gomes da Fonseca Junior",
                "Vinicius Andrade D’Amorim"
        };

        // Preenchendo o ArrayList com 10 instâncias de User
        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setId((long) i);
            user.setName(nomes[i]);
            user.setFullName("Full Name" + i);
            user.setAge(20 + i);
            user.setEmail("user" + i + "@example.com");
            user.setPassword("password" + i);

            userList.add(user);
        }

        // Imprimindo os usuários no ArrayList
        for (User user : userList) {
            System.out.println(user);
        }

        return userList;
    }

}
