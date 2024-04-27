package com.Ada.SkyFeedConnect.service;

import com.Ada.SkyFeedConnect.dto.UserRequestDTO;
import com.Ada.SkyFeedConnect.model.User;
import com.Ada.SkyFeedConnect.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public void addUser(UserRequestDTO userRequestDTO) {
  userRepository.save(new User(userRequestDTO.username()));
  }
}
