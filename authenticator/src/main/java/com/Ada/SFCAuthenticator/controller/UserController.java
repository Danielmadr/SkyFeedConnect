package com.Ada.SFCAuthenticator.controller;

import com.Ada.SFCAuthenticator.dto.UserDTO;
import com.Ada.SFCAuthenticator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService service;

  @PostMapping("/save")
  public ResponseEntity<?> save(@RequestBody UserDTO user) {
    service.save(user);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/all")
  public ResponseEntity<?> findAll() {
    return ResponseEntity.ok(service.findAll());
  }
}
