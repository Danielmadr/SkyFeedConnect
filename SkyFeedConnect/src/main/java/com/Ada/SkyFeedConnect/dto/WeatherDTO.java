package com.Ada.SkyFeedConnect.dto;

import com.Ada.SkyFeedConnect.model.WeatherData;

public record WeatherDTO(Double temp, Double feelsLike) {
  public WeatherDTO(WeatherData weatherData) {
    this(weatherData.getTemperatureInfo().getTemp(), weatherData.getTemperatureInfo().getFeelsLike());
  }
}
