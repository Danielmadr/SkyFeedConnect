package com.Ada.SkyFeedConnect.controller;

import com.Ada.SkyFeedConnect.dto.UserRequestDTO;
import com.Ada.SkyFeedConnect.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping("/newUser")
  public ResponseEntity<String> newUser(@RequestBody UserRequestDTO userRequestDTO) {
    userService.addUser(userRequestDTO);
    return ResponseEntity.status(401).build();
  }
}
