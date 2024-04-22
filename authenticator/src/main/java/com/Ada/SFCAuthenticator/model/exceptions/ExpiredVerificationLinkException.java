package com.Ada.SFCAuthenticator.model.exceptions;

public class ExpiredVerificationLinkException extends RuntimeException {
  public ExpiredVerificationLinkException() {
    super("Expired verification link");
  }
}
