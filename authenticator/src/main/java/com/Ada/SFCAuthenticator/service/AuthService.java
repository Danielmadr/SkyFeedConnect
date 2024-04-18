package com.Ada.SFCAuthenticator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.Ada.SFCAuthenticator.dto.AccessDTO;
import com.Ada.SFCAuthenticator.dto.AuthenticationDTO;
import com.Ada.SFCAuthenticator.security.jwt.JwtUtils;



@Service
public class AuthService {

  /*@Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private UserRepository userRepository;//todo remover para teste*/

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtUtils jwtUtils;

  public AccessDTO login(AuthenticationDTO authDto) {

    try {
      //Cria mecanismo de credencial para o Spring
      UsernamePasswordAuthenticationToken userAuth =
              new UsernamePasswordAuthenticationToken(authDto.username(), authDto.password());

      //Prepara mecanismo para Autenticação
      Authentication authentication = authenticationManager.authenticate(userAuth); //retorna erro 2024-04-17T19:54:37.936-03:00  WARN 1092 --- [SkyFeedConnect] [nio-8080-exec-4] o.s.s.c.bcrypt.BCryptPasswordEncoder     : Encoded password does not look like BCrypt

      //Busca usuario logado
      UserDetailsImpl userAuthDetails = (UserDetailsImpl) authentication.getPrincipal();

      String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthDetails);

      return new AccessDTO(token);

    } catch (BadCredentialsException e) {
     // todo Login ou senha invalidos
      return new AccessDTO(e.getMessage());
    }
  }
}



