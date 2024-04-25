package com.Ada.SFCAuthenticator.model.exceptions;

public class InvalidCredentialsException extends RuntimeException {
  public InvalidCredentialsException() {
    super("Invalid login or password");
  }
}
