package com.Ada.SFCAuthenticator.service;

import com.Ada.SFCAuthenticator.dto.AuthenticationDTO;
import com.Ada.SFCAuthenticator.dto.UserRequestDTO;
import com.Ada.SFCAuthenticator.model.User;
import com.Ada.SFCAuthenticator.dto.UserResponseDTO;
import com.Ada.SFCAuthenticator.model.UserVerifier;
import com.Ada.SFCAuthenticator.model.exceptions.EmailSendingException;
import com.Ada.SFCAuthenticator.model.exceptions.InvalidPasswordException;
import com.Ada.SFCAuthenticator.model.exceptions.UserAlreadyRegisteredException;
import com.Ada.SFCAuthenticator.model.exceptions.UserNotFoundException;
import com.Ada.SFCAuthenticator.repository.UserRepository;
import com.Ada.SFCAuthenticator.repository.UserVerifierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  private final UserVerifierRepository verifierRepository;

  private final PasswordEncoder passwordEncoder;

  private final EmailService emailService;

  public void saveNewUser(UserRequestDTO user) {
    if (userRepository.existsByLogin(user.email())) {
      throw new UserAlreadyRegisteredException(user.email());
    }
    
    if (!isValidPassword(user.password())) {
      throw new InvalidPasswordException();
    }

    User newUser = createUserFromDTO(user);

    UserVerifier verifier = new UserVerifier();
    verifier.setUser(newUser);
    verifier.setUuid(UUID.randomUUID());
    verifier.setExpirationDate(Instant.now().plusMillis(900000));
    verifierRepository.save(verifier);

    sendWelcomeEmail(newUser.getEmail(), verifier);
  }
  private boolean isValidPassword(String password) {
    return password != null && password.length() >= 8;
  }
  private User createUserFromDTO(UserRequestDTO user) {
    User newUser = new User(user);
    newUser.setPassword(encryptPassword(user.password()));
    userRepository.save(newUser);
    return newUser;
  }
  private String encryptPassword(String password) {
    return passwordEncoder.encode(password);
  }
  private void sendWelcomeEmail(String userEmail, UserVerifier user) {
    String subject = "Bem-vindo(a) ao SkyFeedConnect";
    String activationLink = "https://www.skyfeedconnect.com.br/activate/";
    String emailContent = String.format("""
            Seja bem-vindo(a) ao SkyFeedConnect.
                                         
            Confira seu email e acesse o link para ativar sua conta:
            %s
            """, activationLink + user.getUuid());

    try {
      System.out.println(emailService.sendEmail(userEmail, subject, emailContent));//todo apagar apenas para testar
    } catch (Exception e) {
      throw new EmailSendingException();
    }
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
