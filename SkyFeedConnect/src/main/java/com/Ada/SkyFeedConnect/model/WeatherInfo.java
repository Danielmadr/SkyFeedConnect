package com.Ada.SkyFeedConnect.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.List;

@Getter
public class WeatherInfo {

  @JsonIgnoreProperties(ignoreUnknown = true)
  private List<Weather> weather;
  private Main main;
  private String name;

  @JsonIgnoreProperties(ignoreUnknown = true)
  public record Weather(String description, String icon) {}

  @JsonIgnoreProperties(ignoreUnknown = true)
  public record Main(double temp, double feels_like) {}
}
