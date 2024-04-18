package com.Ada.SFCAuthenticator.model.exceptions;

public class UserAlreadyRegistered extends RuntimeException {
  public UserAlreadyRegistered(String parameter, String description) {
    super("Usuário com %s %s já registrado.".formatted(parameter, description) );
  }
}
