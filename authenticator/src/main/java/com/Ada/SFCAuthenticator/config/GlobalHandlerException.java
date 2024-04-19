package com.Ada.SFCAuthenticator.config;

import com.Ada.SFCAuthenticator.dto.ExceptionDTO;
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
  public ResponseEntity<ExceptionDTO> handleUserNotFoundException(UserNotFoundException ex) {
    return ResponseEntity.status(404).body(new ExceptionDTO(ex.getMessage()));
  }

  @ExceptionHandler(InvalidPasswordException.class)
  public ResponseEntity<ExceptionDTO> handleInvalidPasswordException(InvalidPasswordException ex) {
    return ResponseEntity.status(400).body(new ExceptionDTO(ex.getMessage()));
  }

  @ExceptionHandler(UserAlreadyRegisteredException.class)
  public ResponseEntity<ExceptionDTO> handleUserAlreadyRegisteredException(UserAlreadyRegisteredException ex) {
    return ResponseEntity.status(409).body(new ExceptionDTO(ex.getMessage()));
  }

  @ExceptionHandler(ExpiredJwtException.class)
  public ResponseEntity<ExceptionDTO> handleExpiredJwtException(ExpiredJwtException ex) {
    return ResponseEntity.status(401).body(new ExceptionDTO(ex.getMessage()));
  }
  @ExceptionHandler(UnsupportedJwtException.class)
  public ResponseEntity<ExceptionDTO> handleUnsupportedJwtException(UnsupportedJwtException ex) {
    return ResponseEntity.status(401).body(new ExceptionDTO(ex.getMessage()));
  }
  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<ExceptionDTO> handleIllegalArgumentException(IllegalArgumentException ex) {
    return ResponseEntity.status(401).body(new ExceptionDTO(ex.getMessage()));
  }
  @ExceptionHandler(MalformedJwtException.class)
  public ResponseEntity<ExceptionDTO> handleMalformedJwtException(MalformedJwtException ex) {
    return ResponseEntity.status(401).body(new ExceptionDTO(ex.getMessage()));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ExceptionDTO> handleGenericException() {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(new ExceptionDTO("Ocorreu um erro inesperado"));
  }
}