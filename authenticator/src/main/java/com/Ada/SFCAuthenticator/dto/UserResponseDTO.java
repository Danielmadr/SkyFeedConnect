package com.Ada.SFCAuthenticator.dto;

import com.Ada.SFCAuthenticator.model.User;
import com.Ada.SFCAuthenticator.model.enums.UserStatus;

public record UserResponseDTO(
        Long id,
        String username,
        String login,
        String password,
        String email,
        UserStatus status
) {
  public UserResponseDTO(User user) {
    this(
      user.getId(),
      user.getUsername(),
      user.getLogin(),
      user.getPassword(),
      user.getEmail(),
      user.getStatus()
    );
  }
}