package com.sunbeam;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MockEmailNotification implements Notification{

	@Override
	public void send(String to, String msg) {
		// TODO Auto-generated method stub
		System.out.println("Email Notification");
		System.out.println("To : "+to+" | Email : "+msg);
	}

}
