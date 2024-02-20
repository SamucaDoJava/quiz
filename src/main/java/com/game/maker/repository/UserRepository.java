package com.game.maker.repository;

import com.game.maker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findUserById(Long id);

  Optional<User> findByEmailAndPassword(String email, String password);

}
