package com.sunbeam;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("production")
@Component
public class MockSMSNotification implements Notification{

	public void send(String to, String msg) {
		// TODO Auto-generated method stub
		System.out.println("SMS Notification");
		System.out.println("To : "+to+" | SMS : "+msg);
	}
}
