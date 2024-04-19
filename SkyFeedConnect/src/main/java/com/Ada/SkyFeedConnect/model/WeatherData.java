package com.Ada.SkyFeedConnect.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherData {
    @JsonProperty("main")
    private TemperatureInfo temperatureInfo;

    public TemperatureInfo getTemperatureInfo() {
        return temperatureInfo;
    }

    public void setTemperatureInfo(TemperatureInfo temperatureInfo) {
        this.temperatureInfo = temperatureInfo;
    }

    public static class TemperatureInfo {
        private double temp;

        private double feels_like;

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public double getfeelsLike() {
            return feels_like;
        }

        public void setfeels_like(double feels_like) {
            this.feels_like = feels_like;
        }
    }
}
