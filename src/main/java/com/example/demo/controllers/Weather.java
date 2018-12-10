package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.WeatherModel;
import com.example.demo.service.WeatherService;

@Controller
@RequestMapping("/weather")
@CrossOrigin
public class Weather {

	@Autowired
	WeatherService weatherService;
	
	@RequestMapping(value = "/{locZip}", method = RequestMethod.GET)
	@ResponseBody
	public WeatherModel findAll(@PathVariable("locZip") String locZip ) {
		return weatherService.getWeather(locZip);
	}
}
