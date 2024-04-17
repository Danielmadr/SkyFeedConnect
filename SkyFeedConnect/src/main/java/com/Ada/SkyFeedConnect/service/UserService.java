package com.Ada.SkyFeedConnect.service;

import com.Ada.SkyFeedConnect.dto.UserDTO;
import com.Ada.SkyFeedConnect.dto.UsersListDTO;
import com.Ada.SkyFeedConnect.model.User;
import com.Ada.SkyFeedConnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public void save(UserDTO user) {
    User newUser = new User(user);
    newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
    userRepository.save(newUser);
    System.err.println("Usuário salvo com sucesso!");
  }

  public UsersListDTO findAll() {
    return new UsersListDTO(userRepository.findAll());
  }
}
