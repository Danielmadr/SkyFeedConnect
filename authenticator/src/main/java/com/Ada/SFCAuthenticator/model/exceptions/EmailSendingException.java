package com.Ada.SFCAuthenticator.model.exceptions;

public class EmailSendingException extends RuntimeException {
  public EmailSendingException() {
    super("Erro ao enviar email");
  }
}
