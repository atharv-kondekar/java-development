package com.sunbeam.practice;

import org.springframework.context.annotation.Primary;

@Primary
public class MockPushNotification implements Notification{
	@Override
	public void send(String to, String msg) {
		System.out.println("=> PUSH Notification -- to: "+to+"| msg : "+msg);
	}

}
