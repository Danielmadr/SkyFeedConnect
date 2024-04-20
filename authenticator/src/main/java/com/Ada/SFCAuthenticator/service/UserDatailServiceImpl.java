package com.Ada.SFCAuthenticator.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Ada.SFCAuthenticator.model.User;
import com.Ada.SFCAuthenticator.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserDatailServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = this.userRepository.findByLogin(username).orElseThrow(
            () -> new UsernameNotFoundException("User not found"));
    return UserDetailsImpl.build(user);
  }
}
