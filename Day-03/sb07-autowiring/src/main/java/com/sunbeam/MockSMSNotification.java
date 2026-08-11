package com.sunbeam;

import org.springframework.stereotype.Component;

@Component("noti")
public class MockSMSNotification implements Notification{

	public void send(String to, String msg) {
		// TODO Auto-generated method stub
		System.out.println("SMS Notification");
		System.out.println("To : "+to+" | SMS : "+msg);
	}
}
