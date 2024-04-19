package com.Ada.SkyFeedConnect.dto;

import com.Ada.SkyFeedConnect.model.User;
public record userDTO(String userName) {
    public User toUser() {
        return new User(userName);
    }
}