package com.Ada.SFCAuthenticator.repository;

import com.Ada.SFCAuthenticator.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByLogin(String login);

  boolean existsByLogin(String login);

  boolean existsByEmail(String email);
}
