package com.Ada.SkyFeedConnect.service;

import com.Ada.SkyFeedConnect.model.User;
import com.Ada.SkyFeedConnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDatailServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByLogin(username).get();
    //todo tratar erro
    return UserDetailsImpl.build(user);
  }
}
