package com.Ada.SFCAuthenticator.model;

import com.Ada.SFCAuthenticator.dto.UserRequestDTO;
import com.Ada.SFCAuthenticator.model.enums.UserStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import com.Ada.SFCAuthenticator.dto.UserResponseDTO;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Setter
@Getter
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String username;

  @Column(nullable = false, unique = true)
  private String login;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false, unique = true)
  private String email;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private UserStatus status;

  public User(UserResponseDTO userDTO) {
    BeanUtils.copyProperties(userDTO, this);
  }
  public User(UserRequestDTO userDTO) {
    BeanUtils.copyProperties(userDTO, this);
  }
}
