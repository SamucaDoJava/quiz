package com.game.maker.repository.temp;

import com.game.maker.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
public class UserFakeDataBase {
    private List<User> userList = new ArrayList<>();

    @Bean(name = "userTemporaryDataBaseInMemoryFindAll")
    public List<User> ShowMeMyFakeUserDataBaseValues() {
        if (userList.isEmpty()) {
            initializeUserList();
        }
        return new ArrayList<>(userList);
    }

    // Método privado para inicializar a lista de usuários
    private void initializeUserList() {
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

        this.userList = userList;
    }

}
