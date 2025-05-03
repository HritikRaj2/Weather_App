package com.Weatherapp.demo.api.response;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class WeatherResponse {
    private Current current;


    @Setter
    @Getter
    public static class Current{

        private int temperature;
        private int weather_code;

        private int wind_speed;
        private int wind_degree;
        private String wind_dir;
        private int pressure;
        private int precip;
        private int humidity;
        private int cloudcover;
        private int feelslike;
        private int uv_index;
        private int visibility;
        private String is_day;
    }
}
