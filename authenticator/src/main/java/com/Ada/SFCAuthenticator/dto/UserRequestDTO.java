package com.Ada.SFCAuthenticator.dto;

import com.Ada.SFCAuthenticator.model.enums.UserStatus;

public record UserRequestDTO(
        String username,
        String email,
        String password,
        UserStatus status
) {
}
