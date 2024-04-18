package com.Ada.SFCAuthenticator.model.exceptions;

public class UserAlreadyRegisteredException extends RuntimeException {
  public UserAlreadyRegisteredException(String parameter, String description) {
    super("Usuário com %s %s já registrado.".formatted(parameter, description) );
  }
}
