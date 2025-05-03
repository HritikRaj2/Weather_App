package com.Weatherapp.demo.controller;


import com.Weatherapp.demo.api.response.WeatherResponse;
import com.Weatherapp.demo.service.WeatherSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private WeatherSevice weatherSevice;


    @GetMapping("/mapp")
    public ResponseEntity<?> greeting(@RequestParam String city){
        WeatherResponse weatherResponse=weatherSevice.getWeather(city);
        String greeting="";
        if(weatherResponse!=null){
            greeting="The Weather FeelsLike="+ weatherResponse.getCurrent().getFeelslike()+"°C" + "\nTemperature is="+weatherResponse.getCurrent().getTemperature()+"°C";
        }



        return new ResponseEntity<>("Hi User, In "+city+"\n"+greeting , HttpStatus.OK);
    }
}
