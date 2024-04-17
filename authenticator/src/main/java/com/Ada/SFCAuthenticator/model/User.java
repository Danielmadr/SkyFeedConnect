package com.Ada.SFCAuthenticator.model;

import com.Ada.SFCAuthenticator.dto.UserDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

  @Column(nullable = false)
  private String email;


  public User(UserDTO userDTO) {
    BeanUtils.copyProperties(userDTO, this);
  }

}
