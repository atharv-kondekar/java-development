package com.sunbeam.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NotificationSender {
	@Autowired(required = false)
	@Qualifier("mockEmailNotification")
	private Notification sender;

	public void notifyUser( String to , String msg) {
		if(sender!=null) {
			sender.send(to, msg);
		}
		else {
			System.out.println("Can't send: "+msg+"\nto : "+to);
		}
	}
}
