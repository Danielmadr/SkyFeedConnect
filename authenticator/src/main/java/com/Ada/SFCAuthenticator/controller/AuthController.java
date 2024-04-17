package com.Ada.SFCAuthenticator.controller;

import com.Ada.SFCAuthenticator.dto.AuthenticationDTO;
import com.Ada.SFCAuthenticator.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

  @Autowired
  private AuthService service;

  @PostMapping(value = "/login")
  public ResponseEntity<?> login(@RequestBody AuthenticationDTO loginInfo) {
    return ResponseEntity.ok(service.login(loginInfo));
  }
}
