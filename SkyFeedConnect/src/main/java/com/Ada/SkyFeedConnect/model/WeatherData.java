package com.Ada.SkyFeedConnect.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class WeatherData {
  @JsonProperty("main")
  private TemperatureInfo temperatureInfo;

  public record TemperatureInfo (
          Double temp,
          @JsonProperty("feels_like")
          Double feelsLike
  ){
  }
}
