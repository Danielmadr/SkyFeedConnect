package com.Ada.SFCAuthenticator.security.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.Ada.SFCAuthenticator.service.UserDatailServiceImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthFilterToken extends OncePerRequestFilter {

  @Autowired
  private JwtUtils jwtUtils;

  @Autowired
  private UserDatailServiceImpl userDatailService;

  @Override
  protected void doFilterInternal(
          HttpServletRequest request,
          HttpServletResponse response,
          FilterChain filterChain) throws ServletException, IOException {
    try {
      String jwt = getToken(request);
      if (jwt != null && jwtUtils.validateJwtToken(jwt)) {

        String username = jwtUtils.getUserNameFromJwtToken(jwt);

        UserDetails userDetails = userDatailService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authToken);
      }
    }catch (Exception e) {
      System.out.println("Ocorreu um erro ao tentar autenticar o token JWT: " + e.getMessage());
    }
    filterChain.doFilter(request, response);
  }

  private String getToken(HttpServletRequest request) {
    String authHeader = request.getHeader("Authorization");
    if (StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer")) {
      return authHeader.replace("Bearer ", "");
    }
    return null;
  }
}
