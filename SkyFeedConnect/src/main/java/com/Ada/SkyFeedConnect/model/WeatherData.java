package com.Ada.SkyFeedConnect.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherData {
    @JsonProperty("main")
    private TemperatureInfo temperatureInfo;

    public TemperatureInfo getTemperatureInfo() {
        return temperatureInfo;
    }

    public static class TemperatureInfo {
        private double temp;
        @JsonProperty("feels_like")
        private double feelsLike;

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public double getfeelsLike() {
            return feelsLike;
        }

        public void setfeels_like(double feels_like) {
            this.feelsLike = feels_like;
        }
    }
}
