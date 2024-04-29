package com.Ada.SFCAuthenticator.model.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AccountAlreadyVerifiedOrWrongLinkException extends RuntimeException {
  public AccountAlreadyVerifiedOrWrongLinkException() {
    super("Account already verified or wrong link");
  }
}
