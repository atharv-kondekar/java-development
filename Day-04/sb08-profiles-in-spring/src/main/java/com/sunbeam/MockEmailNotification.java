package com.sunbeam;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBooleanProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("developer")
@Component
public class MockEmailNotification implements Notification{

	@Override
	public void send(String to, String msg) {
		// TODO Auto-generated method stub
		System.out.println("Email Notification");
		System.out.println("To : "+to+" | Email : "+msg);
	}

}
