package com.Ada.SkyFeedConnect.service;

import com.Ada.SkyFeedConnect.dto.AcessDTO;
import com.Ada.SkyFeedConnect.dto.AuthenticationDTO;
import com.Ada.SkyFeedConnect.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  @Autowired
  private AuthenticationManager manager;
  private JwtUtils jwtUtils;

  public AcessDTO login(AuthenticationDTO loginInfo) {
    try {
      //Cria mecanismo de credencial para o Spring
      UsernamePasswordAuthenticationToken userAuth =
              new UsernamePasswordAuthenticationToken(loginInfo.username(), loginInfo.password());

      //Prepara mecanismo para Autenticação
      Authentication authentication = manager.authenticate(userAuth);

      //Busca usuario logado
      UserDetailsImpl userAuthDetails = (UserDetailsImpl) authentication.getPrincipal();

      String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthDetails);

      return new AcessDTO(token);
    } catch (BadCredentialsException e) {
      //todo Login ou senha invalidos
      return new AcessDTO(e.getMessage() + " " + loginInfo.username() + " " + loginInfo.password());
    }
  }
}



