package com.sunbeam.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TcpSender implements ReadingSender{

	@Autowired
	@Qualifier("humiditySensor")
	private Sensor sensor;

	@Override
	public void send() {
		System.out.println("Sending over TCP : " + sensor.readValue());
	}
}
