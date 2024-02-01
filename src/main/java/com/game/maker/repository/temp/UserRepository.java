package com.game.maker.repository.temp;

import com.game.maker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**Essa classe repository na verdade em projetos reais é uma Interface, iremos mudar ela para interface quando colocarmos um banco de dados real
 * Por hora estamos lendo nossos dados de uma base de dados Fake que nós escrevemos em código e armazenamos apenas em memória, porém em breve
 * iremos armazenar mesmo os nossos dados em um sistema de banco de dados robusto e confiável, e para isso precisaremos mexer e muito nessa camada
 * Essa classe virará uma Interface e não terá métodos declarados, apenas a parte da primeira linha de cada método será mantido! por exempo<br/><br/>
 * User save(User user) <br/>
 * Optional<User> findByEmailAndPassword(String email, String password);<br/>
 * Optional<User> findByEmailAndPassword(String email, String password);<br/>
 * List<User> findAll(); <br/>
 * findUserById(Long id); <br/><br/>
 * Lembrando que eu já mentive a sintaxe correta das chamadas acima, então em UserRepository Interface iremos usar exatamente como foi representado antes nesse texto.
 * Porém usaremos dentro de uma interface.<br/><br/>
 * O Objetivo de não usarmos nenhum tipo de banco de dados e nem em memória é ter a plena visão do que está sendo feito e que podemos a qualquer momento implementar
 * um banco de dados seja H2 ou PostgresSQL ou Oracle usando Hibernate sem quebrar o nosso código, mas isso só será possível se formos estratégicos e fizermos o nosso
 * código sendo pensado para isso! Esse código está sendo preparado para apenas ser modificado nessa camada e o resto precisa constinuar integro e funcional!
 * */
@Component
public class UserRepository {

    //TODO Remover o user fakedatabase e colocar essa classe UserRepository na raiz de repository como uma interface, implementar o hibernate configurar o banco postgresSQL criar o arquivo properties do tipo create para criar as tabelas ao subir o sistema.
    @Autowired
    private UserFakeDataBase userFakeDataBase;

    //TODO Quando implementarmos o JPA e banco de dados o JPA vai fazer isso para nós automáticamente, não vamos precisar fazer nada apenas chamar o repository.save(objeto)
    public User save(User user) {
        userFakeDataBase.ShowMeMyFakeUserDataBaseValues().add(user);
        return user;
    }

    //TODO Esta chamada também será feita pelo JPA do hibernate, a sintaxe já está correta, só precisa ser adaptada na interface algo como Optional<User> findByEmailAndPassword(String email, String password);
    public Optional<User> findByEmailAndPassword(String email, String password) {
        return userFakeDataBase.ShowMeMyFakeUserDataBaseValues().stream()
                .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
                .findFirst();
    }

    //TODO Assim como o findByEmailAndPassword o findAll() já está seguindo a nomenclatura correta do JPA e pode ser aproveitada a sua declaração na iterface do UserRepository
    public List<User> findAll() {
        return userFakeDataBase.ShowMeMyFakeUserDataBaseValues();
    }

    //TODO A mesma lógica de reaproveitamento acontece aqui no findUserById
    public Optional<User> findUserById(Long id){
        return userFakeDataBase.ShowMeMyFakeUserDataBaseValues().stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

}
