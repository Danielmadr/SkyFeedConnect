package com.Ada.SFCAuthenticator.service;

import com.Ada.SFCAuthenticator.model.User;
import com.Ada.SFCAuthenticator.dto.UserDTO;
import com.Ada.SFCAuthenticator.dto.UsersListDTO;
import com.Ada.SFCAuthenticator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public void save(UserDTO user) {
    User newUser = new User(user);
    newUser.setPassword(passwordEncoder.encode(user.password()));
    userRepository.save(newUser);
    System.err.println("Usuário salvo com sucesso!");
  }

  public UsersListDTO findAll() {
    return new UsersListDTO(userRepository.findAll());
  }
}
