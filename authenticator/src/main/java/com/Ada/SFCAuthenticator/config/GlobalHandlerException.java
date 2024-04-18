package com.Ada.SFCAuthenticator.config;

import com.Ada.SFCAuthenticator.dto.ExceptionDTO;
import com.Ada.SFCAuthenticator.model.exceptions.InvalidPasswordException;
import com.Ada.SFCAuthenticator.model.exceptions.UserAlreadyRegistered;
import com.Ada.SFCAuthenticator.model.exceptions.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<ExceptionDTO> handleUserNotFoundException(UserNotFoundException ex) {
    return ResponseEntity.status(404).body(new ExceptionDTO(ex.getMessage()));
  }

  @ExceptionHandler(InvalidPasswordException.class)
  public ResponseEntity<ExceptionDTO> handleInvalidPasswordException(InvalidPasswordException ex) {
    return ResponseEntity.status(400).body(new ExceptionDTO(ex.getMessage()));
  }

  @ExceptionHandler(UserAlreadyRegistered.class)
  public ResponseEntity<ExceptionDTO> handleUserAlreadyRegisteredException(UserAlreadyRegistered ex) {
    return ResponseEntity.status(409).body(new ExceptionDTO(ex.getMessage()));
  }
}