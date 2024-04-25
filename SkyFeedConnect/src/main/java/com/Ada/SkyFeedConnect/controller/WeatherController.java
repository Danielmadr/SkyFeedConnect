package com.Ada.SkyFeedConnect.controller;

import com.Ada.SkyFeedConnect.dto.WeatherResponseDTO;
import com.Ada.SkyFeedConnect.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherController {

  private final WeatherService weatherService;

  @GetMapping("/weather/{city}")
  public ResponseEntity<WeatherResponseDTO> getWeather(@PathVariable String city) {
    return ResponseEntity.ok(weatherService.getWeatherByCity(city));
  }
}

