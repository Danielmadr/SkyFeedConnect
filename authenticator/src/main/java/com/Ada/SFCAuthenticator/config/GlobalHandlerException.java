package com.Ada.SFCAuthenticator.config;

import com.Ada.SFCAuthenticator.dto.ExceptionMessageDTO;
import com.Ada.SFCAuthenticator.model.exceptions.InvalidPasswordException;
import com.Ada.SFCAuthenticator.model.exceptions.UserAlreadyRegisteredException;
import com.Ada.SFCAuthenticator.model.exceptions.UserNotFoundException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<ExceptionMessageDTO> handleUserNotFoundException(UserNotFoundException ex) {
    return ResponseEntity.status(404).body(new ExceptionMessageDTO(ex.getMessage()));
  }

  @ExceptionHandler(InvalidPasswordException.class)
  public ResponseEntity<ExceptionMessageDTO> handleInvalidPasswordException(InvalidPasswordException ex) {
    return ResponseEntity.status(400).body(new ExceptionMessageDTO(ex.getMessage()));
  }

  @ExceptionHandler(UserAlreadyRegisteredException.class)
  public ResponseEntity<ExceptionMessageDTO> handleUserAlreadyRegisteredException(UserAlreadyRegisteredException ex) {
    return ResponseEntity.status(409).body(new ExceptionMessageDTO(ex.getMessage()));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ExceptionMessageDTO> handleGenericException() {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(new ExceptionMessageDTO("Ocorreu um erro inesperado"));
  }
}