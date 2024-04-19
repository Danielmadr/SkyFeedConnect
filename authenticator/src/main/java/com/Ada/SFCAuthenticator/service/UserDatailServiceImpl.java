package com.Ada.SFCAuthenticator.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Ada.SFCAuthenticator.model.User;
import com.Ada.SFCAuthenticator.repository.UserRepository;
@Service
public class UserDatailServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByLogin(username).get();
    return UserDetailsImpl.build(user);
  }
}
