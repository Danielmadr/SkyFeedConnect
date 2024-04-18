package com.Ada.SFCAuthenticator.dto;

import com.Ada.SFCAuthenticator.model.User;
import org.springframework.beans.BeanUtils;

public class UserDTO {
  private Long id;
  private String username;
  private String login;
  private String password;
  private String email;

  public UserDTO(User usuario) {
    BeanUtils.copyProperties(usuario, this);
  }

  public UserDTO() {
  }

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getLogin() {
    return login;
  }
  public void setLogin(String login) {
    this.login = login;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
}
