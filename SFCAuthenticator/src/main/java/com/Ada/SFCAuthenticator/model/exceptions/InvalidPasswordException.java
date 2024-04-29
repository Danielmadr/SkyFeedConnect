package com.Ada.SFCAuthenticator.model.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class InvalidPasswordException extends RuntimeException {
  public InvalidPasswordException() {
    super("Senha inválida. Tente novamente.");
  }
}
