package com.sunbeam.practice;

import org.springframework.stereotype.Component;

@Component
public class TempeatureSensor implements Sensor{

	public int readValue() {
		return (int) (Math.random()*21)+10;
	}
}
