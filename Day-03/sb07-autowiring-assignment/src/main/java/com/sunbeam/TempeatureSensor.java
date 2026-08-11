package com.sunbeam;

import org.springframework.stereotype.Component;

@Component
public class TempeatureSensor implements Sensor {

	@Override
	public int readValue() {
		// 10 to 30 is 21 digits
		// 10 is the starting number
		return (int) (Math.random()*21)+10;
	}
}
