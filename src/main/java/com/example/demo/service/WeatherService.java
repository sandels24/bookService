package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.WeatherModel;

@Service
public class WeatherService {

	public WeatherModel getWeather(String locZip) {
		
		RestTemplate restTemplate = new RestTemplate();
		WeatherModel weatherModel = restTemplate.getForObject("https://api.amwater.com/api/aw-weather-api/v1/weather-details/zipcode/"+locZip+"?hourly", WeatherModel.class);
		return weatherModel;
	}
}
