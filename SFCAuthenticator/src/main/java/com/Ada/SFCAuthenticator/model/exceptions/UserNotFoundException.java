package com.Ada.SFCAuthenticator.model.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class UserNotFoundException extends RuntimeException {

  public UserNotFoundException(String login) {
    super("Usuário '" + login + "' não encontrado!");
  }
}
