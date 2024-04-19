package com.Ada.SFCAuthenticator.controller;

import com.Ada.SFCAuthenticator.dto.UserResponseDTO;
import com.Ada.SFCAuthenticator.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class testController {

  private final UserService userService;

  @GetMapping("/{login}")
  public ResponseEntity<UserResponseDTO> test(@PathVariable String login) {
    UserResponseDTO user = userService.findByLogin(login);
    return ResponseEntity.ok(user);
  }
}
