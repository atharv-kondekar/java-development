package com.sunbeam;

import org.springframework.stereotype.Component;

@Component
public class HumiditySensor implements Sensor {

	public int readValue() {
		// 40 to 100 = 61 digits
		// 40 is the starting number
		return (int) (Math.random()*61)+40;
	}
}
