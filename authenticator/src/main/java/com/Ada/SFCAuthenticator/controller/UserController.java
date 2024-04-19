package com.Ada.SFCAuthenticator.controller;

import com.Ada.SFCAuthenticator.dto.AuthenticationDTO;
import com.Ada.SFCAuthenticator.dto.UserRequestDTO;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Ada.SFCAuthenticator.dto.UserResponseDTO;
import com.Ada.SFCAuthenticator.service.UserService;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value ="/users")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping("/save")
  public ResponseEntity<?> saveNewUser(@RequestBody UserRequestDTO user, UriComponentsBuilder uriComponentsBuilder) {
    this.userService.saveNewUser(user);
    var uri = uriComponentsBuilder.path("/users/all").build().toUri();
    return ResponseEntity.created(uri).build();
  }

  @DeleteMapping("/delete")
  public ResponseEntity<?> delete(@RequestBody AuthenticationDTO access) {
    this.userService.delete(access);
    return ResponseEntity.ok().build();
  }

}
