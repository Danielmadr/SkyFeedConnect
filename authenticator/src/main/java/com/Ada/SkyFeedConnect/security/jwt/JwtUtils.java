package com.Ada.SkyFeedConnect.security.jwt;

import com.Ada.SkyFeedConnect.service.UserDetailsImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

  @Value("${projeto.jwtSecret}")//chave de segurança definida nas proproedades do projeto.
  private String jwtSecret;

  @Value("${projeto.jwtExpirationMs}")
  private int jwtExpirationMs;//tempo de expiração do token, definido nas propriedades do projeto.

  public String generateTokenFromUserDetailsImpl(UserDetailsImpl userDetails) {
    return Jwts.builder()
            .setSubject(userDetails.getUsername())
            .setIssuedAt(new Date())
            .setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
            .signWith(getSigningKey(), SignatureAlgorithm.HS512)
            .compact();
  }

  public Key getSigningKey() {
    return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
  }

  public boolean validateJwtToken(String token) {
    try {
      Jwts.parser().setSigningKey(getSigningKey()).build().parseClaimsJws(token);
      return true;
    } catch (MalformedJwtException e) {
      System.out.println("Token inválido" + e.getMessage());

      //todo: pesquisar sobre logForJ

    } catch (ExpiredJwtException e) {
      System.out.println("Token expirado");
    } catch (UnsupportedJwtException e) {
      System.out.println("Token não suportado");
    } catch (IllegalArgumentException e) {
      System.out.println("Token vazio" + e.getMessage());
    }
    return false;
  }

  public String getUserNameFromJwtToken(String jwt) {
    return Jwts.parser().setSigningKey(getSigningKey()).build().parseClaimsJws(jwt).getBody().getSubject();
  }
}

