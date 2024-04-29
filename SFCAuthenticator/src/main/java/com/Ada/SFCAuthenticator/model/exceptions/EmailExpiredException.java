package com.Ada.SFCAuthenticator.model.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class EmailExpiredException extends RuntimeException {

  public EmailExpiredException() {
    super("Link de verificação expirado. Um novo link foi enviado para o seu e-mail.");
  }
}
