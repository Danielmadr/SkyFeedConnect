package com.Ada.SkyFeedConnect.service;
import com.Ada.SkyFeedConnect.dto.WeatherDTO;
import com.Ada.SkyFeedConnect.model.WeatherData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${openweather.api.key}")
    private String apiKey;

    public WeatherDTO getWeatherByCity(String city) {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";
        RestTemplate restTemplate = new RestTemplate();
        WeatherData weatherData = restTemplate.getForObject(url, WeatherData.class);

        return new WeatherDTO(weatherData);
    }
}
