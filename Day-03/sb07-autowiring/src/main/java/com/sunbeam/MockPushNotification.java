package com.sunbeam;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class MockPushNotification implements Notification{

	public void send(String to, String msg) {
		// TODO Auto-generated method stub
		System.out.println("Push Notification");
		System.out.println("To : "+to+" | Msg : "+msg);
	}
}
