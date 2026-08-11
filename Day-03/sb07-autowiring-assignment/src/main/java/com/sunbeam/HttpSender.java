package com.sunbeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class HttpSender implements ReadingSender {

	@Autowired
	@Qualifier("tempeatureSensor")
	private Sensor sensor;

	@Override
	public void send() {
		System.out.println("Sending Over HTTP : "+sensor.readValue());
	}

}
