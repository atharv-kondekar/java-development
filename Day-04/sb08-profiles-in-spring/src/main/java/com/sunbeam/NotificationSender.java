package com.sunbeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


@Component
public class NotificationSender {

	private Notification noti;

	NotificationSender(Notification noti) {
		this.noti = noti;
	}

	public void notify(String to,String msg) {
		if( noti!= null)
			noti.send(to, msg);
		else {
			System.out.println("Can't Send Notification");
		}
	}
}
