package com.Ada.SFCAuthenticator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

  @Value("${spring.mail.username}")
  private String sender;

  private final JavaMailSender javaMailSender;

  public String sendEmail(String destiny, String subject, String body) {
    try {
      SimpleMailMessage message = new SimpleMailMessage();
      message.setFrom(sender);
      message.setTo(destiny);
      message.setSubject(subject);
      message.setText(body);
      javaMailSender.send(message);

      return "Email enviado com sucesso!";
    } catch (Exception e) {
      return "Erro ao enviar email: " + e.getMessage();
    }
  }
}
