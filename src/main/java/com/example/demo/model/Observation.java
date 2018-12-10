package com.example.demo.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@JsonIgnoreProperties
public class Observation {

	public Imperial imperial;
	public String sky_cover;
	public String dow;
}
