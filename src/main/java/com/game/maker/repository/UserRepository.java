package com.game.maker.repository;

import com.game.maker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);
    Optional<User> findByEmailAndPassword(String email, String password);

    List<User> findAll();
    Optional<User> findUserById(Long id);

}
