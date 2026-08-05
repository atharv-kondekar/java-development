package com.sunbeam.practice;

import org.springframework.stereotype.Component;

@Component
public class MockEmailNotification implements Notification{

	@Override
	public void send(String to, String msg) {
		System.out.println("=> Email -- to: "+to+"| mail: "+msg);
	}

}
