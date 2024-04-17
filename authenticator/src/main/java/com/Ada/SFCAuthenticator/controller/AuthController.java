package com.Ada.SFCAuthenticator.controller;

import com.Ada.SFCAuthenticator.dto.AuthenticationDTO;
import com.Ada.SFCAuthenticator.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
//@CrossOrigin ver necessidade
public class AuthController {

  @Autowired
  private AuthService service;

  @PostMapping(value = "/login")
  public ResponseEntity<?> login(@RequestBody AuthenticationDTO loginInfo) {
    return ResponseEntity.ok().body(service.login(loginInfo));
  }
}
