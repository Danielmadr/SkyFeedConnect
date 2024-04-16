package com.Ada.SkyFeedConnect.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetailsImpl implements UserDetails {

  private Long id;
  private String name;
  private String username;
  private String email;
  private String password;

  private Collection<? extends GrantedAuthority> authorities;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.authorities;
  }

  @Override
  public String getPassword() {
    return this.password;
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
