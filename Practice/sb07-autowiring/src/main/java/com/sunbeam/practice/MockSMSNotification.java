package com.sunbeam.practice;

import org.springframework.stereotype.Component;

@Component("sender")
public class MockSMSNotification implements Notification{

	@Override
	public void send(String to, String msg) {
		System.out.println("=> SMS -- to: "+to+"| msg : "+msg);
	}

}
