package com.Ada.SkyFeedConnect.dto;

import com.Ada.SkyFeedConnect.model.WeatherInfo;

public record WeatherResponseDTO(String description, String icon, double temp, double feels_like, String name) {
  public static WeatherResponseDTO toDTO(WeatherInfo weatherData) {
    WeatherInfo.Weather weather = weatherData.getWeather().getFirst();
    WeatherInfo.Main main = weatherData.getMain();
    return new WeatherResponseDTO(weather.description(), weather.icon(), main.temp(), main.feels_like(), weatherData.getName());
  }

}