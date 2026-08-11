package com.sunbeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SoapSender implements ReadingSender {

	@Autowired
	@Qualifier("humiditySensor")
	private Sensor sensor;

	@Override
	public void send() {
		// TODO Auto-generated method stub
		System.out.println("Sending over SOAP : "+sensor.readValue());
	}
}
