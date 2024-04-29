package com.Ada.SFCAuthenticator.model.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class EmailSendingException extends RuntimeException {
  public EmailSendingException() {
    super("Erro ao enviar email");
  }
}
