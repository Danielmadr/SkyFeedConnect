package com.Ada.SFCAuthenticator.model.exceptions;

public class InvalidPasswordException extends RuntimeException{
  public InvalidPasswordException() {
    super("Senha inválida. Tente novamente.");
  }
}
