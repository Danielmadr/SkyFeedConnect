package com.Ada.SkyFeedConnect.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

   @GetMapping("/hello")
  public ResponseEntity<String> helloWorld(HttpServletRequest request) {

      return ResponseEntity.ok("Hello World");

  }

}
