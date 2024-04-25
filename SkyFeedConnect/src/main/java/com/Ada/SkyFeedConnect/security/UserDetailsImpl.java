package com.Ada.SkyFeedConnect.security;

import java.util.Collection;

import com.Ada.SkyFeedConnect.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {

  private final String username;

  public UserDetailsImpl(String username) {
    super();
    this.username = username;
  }

  public static UserDetailsImpl build(User user) {

    return new UserDetailsImpl(
            user.getUsername());
  }


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getPassword() {
    return null;
  }

  @Override
  public String getUsername() {
    return this.username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true; //A princípio o usuário nunca expira
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;//A princípio o usuário nunca fica bloqueado
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true; //A princípio o usuário nunca expira
  }

  @Override
  public boolean isEnabled() {
    return true; //A princípio o usuário nunca expira
  }
}