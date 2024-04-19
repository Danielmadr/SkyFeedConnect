package com.Ada.SFCAuthenticator.dto;

import com.Ada.SFCAuthenticator.model.enums.UserStatus;

public record UserRequestDTO(
        String username,
        String login,
        String password,
        String email,
        UserStatus status
) {
}
