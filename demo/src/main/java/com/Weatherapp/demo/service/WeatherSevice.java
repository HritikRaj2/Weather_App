package com.Weatherapp.demo.service;


import com.Weatherapp.demo.api.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherSevice {
    @Value("${Weather.api.key}")
    private String apiKey;
    @Autowired
    private RestTemplate restTemplate;
    public WeatherResponse getWeather(String city) {
        String apiTemplate = "http://api.weatherstack.com/current?access_key=apikey&query=<city>";
        if (apiTemplate == null) {
            throw new RuntimeException("Missing 'weather_api' configuration in AppCache");
        }

        String finalAPI = apiTemplate.replace("<city>", city).replace("apikey", apiKey);

        ResponseEntity<WeatherResponse> response = restTemplate.exchange(
                finalAPI, HttpMethod.GET, null, WeatherResponse.class
        );

        return response.getBody();
    }

}

//wap to implem default packages
