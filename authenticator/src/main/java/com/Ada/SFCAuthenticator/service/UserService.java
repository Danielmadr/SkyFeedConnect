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

  private final EmailService emailService;

  public void saveNewUser(UserRequestDTO user) {
    if (userRepository.existsByLogin(user.email())) {
      throw new UserAlreadyRegisteredException(user.email());
    }

    User newUser = new User(user);
    newUser.setPassword(passwordEncoder.encode(user.password()));
    newUser.setStatus(UserStatus.PENDING);
    userRepository.save(newUser);

    emailService.sendEmail(
            user.email(),
            "Bem vindo(a) ao SkyFeedConnect",
            """
                    Seja bem vindo(a) ao SkyFeedConnect.\s
                                        
                    Confira seu email e acesse o link para ativar sua conta: https://www.skyfeedconnect.com.br/activate/"""
    );
  }

  public void delete(AuthenticationDTO access) {
    User user = userRepository.findByLogin(access.username()).orElseThrow(
            () -> new UserNotFoundException(access.username())
    );

    if (passwordEncoder.matches(access.password(), user.getPassword())) {
      userRepository.delete(user);
    } else {
      throw new InvalidPasswordException();
    }
  }

  public UserResponseDTO findByLogin(String login) { //todo para teste
    User user = userRepository.findByLogin(login).orElseThrow(
            () -> new UserNotFoundException(login)
    );
    return new UserResponseDTO(user);
  }

  public void testSendEmail(String email) {//todo apagar apenas para testar
    try {
      String message = emailService.sendEmail(
              email,
              "Bem vindo(a) ao SkyFeedConnect",
              "Seja bem vindo(a) ao SkyFeedConnect. Confira seu email e acesse o link para ativar sua conta: https://www.skyfeedconnect.com.br/activate/"
      );
      System.out.println("Email enviado com sucesso!\n" + message);
    } catch (Exception e) {
      System.err.println("Erro ao enviar email: " + e.getMessage());
    }
  }
}
