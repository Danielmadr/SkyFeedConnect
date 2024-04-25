package com.Ada.SkyFeedConnect.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
public class WeatherData {
  @JsonProperty("main")
  private TemperatureInfo temperatureInfo;


  @Getter
  @Setter
  public static class TemperatureInfo {
    private double temp;
    @JsonProperty("feels_like")
    private double feelsLike;
  }
}
