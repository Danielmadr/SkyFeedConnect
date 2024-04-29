package com.Ada.SkyFeedConnect.controller;

import com.Ada.SkyFeedConnect.dto.UserRequestDTO;
import com.Ada.SkyFeedConnect.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
@CrossOrigin
public class UserController {

  private final UserService userService;

  @PostMapping("/newUser")
  public ResponseEntity<String> newUser(@RequestBody UserRequestDTO userRequestDTO) {
    userService.addUser(userRequestDTO);
    return ResponseEntity.created(null).build();
  }
}
