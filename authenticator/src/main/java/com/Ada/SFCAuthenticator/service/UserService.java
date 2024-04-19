package com.Ada.SFCAuthenticator.service;

import com.Ada.SFCAuthenticator.dto.AuthenticationDTO;
import com.Ada.SFCAuthenticator.dto.UserRequestDTO;
import com.Ada.SFCAuthenticator.model.User;
import com.Ada.SFCAuthenticator.dto.UserResponseDTO;
import com.Ada.SFCAuthenticator.model.enums.UserStatus;
import com.Ada.SFCAuthenticator.model.exceptions.InvalidPasswordException;
import com.Ada.SFCAuthenticator.model.exceptions.UserAlreadyRegisteredException;
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

  public void saveNewUser(UserRequestDTO user) {
    if(userRepository.existsByLogin(user.login())) {
      throw new UserAlreadyRegisteredException("login", user.login());
    }
    if(userRepository.existsByEmail(user.email())) {
      throw new UserAlreadyRegisteredException("email", user.email());
    }

    User newUser = new User(user);
    newUser.setPassword(passwordEncoder.encode(user.password()));
    newUser.setStatus(UserStatus.PENDING);
    userRepository.save(newUser);

    //todo verificação e conta
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

  public UserResponseDTO findByLogin(String login) { //todo para teste
    User user = userRepository.findByLogin(login).orElseThrow(
      () -> new UserNotFoundException(login)
    );
    return new UserResponseDTO(user);
  }





}
