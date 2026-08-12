package com.sunbeam;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("tester")
@Component
public class MockPushNotification implements Notification{

	public void send(String to, String msg) {
		// TODO Auto-generated method stub
		System.out.println("Push Notification");
		System.out.println("To : "+to+" | Msg : "+msg);
	}
}
