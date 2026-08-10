package com.sunbeam.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class HttpSender implements ReadingSender {

	@Autowired
	@Qualifier("tempeatureSensor")
	private Sensor sensor;

	@Override
	public void send() {
		System.out.println("Sending over HTTP : " + sensor.readValue());
	}
}
