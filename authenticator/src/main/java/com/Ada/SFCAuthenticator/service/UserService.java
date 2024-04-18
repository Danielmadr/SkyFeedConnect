package com.Ada.SFCAuthenticator.service;

import com.Ada.SFCAuthenticator.dto.AccessDTO;
import com.Ada.SFCAuthenticator.dto.AuthenticationDTO;
import com.Ada.SFCAuthenticator.model.User;
import com.Ada.SFCAuthenticator.dto.UserDTO;
import com.Ada.SFCAuthenticator.dto.UsersListDTO;
import com.Ada.SFCAuthenticator.model.exceptions.InvalidPasswordException;
import com.Ada.SFCAuthenticator.model.exceptions.UserAlreadyRegistered;
import com.Ada.SFCAuthenticator.model.exceptions.UserNotFoundException;
import com.Ada.SFCAuthenticator.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  private final PasswordEncoder passwordEncoder;

  public void save(UserDTO user) {
    if(userRepository.existsByLogin(user.getLogin())) {
      throw new UserAlreadyRegistered("login", user.getLogin());
    }

    if(userRepository.existsByEmail(user.getEmail())) {
      throw new UserAlreadyRegistered("email", user.getEmail());
    }

    User newUser = new User(user);
    String encodedPassword = passwordEncoder.encode(user.getPassword());
    newUser.setPassword(encodedPassword);
    userRepository.save(newUser);
  }

  public void delete(AuthenticationDTO access) {
    User user = userRepository.findByLogin(access.username()).orElseThrow(
      () -> new UserNotFoundException(access.username())
    );

    if (passwordEncoder.matches(access.password(), user.getPassword())) {
      userRepository.delete(user);
    }else {
      throw new InvalidPasswordException();
    }
  }




}
