package com.sunbeam.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sb07AutowiringApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Sb07AutowiringApplication.class, args);
	}

	//@Value("#{notificationSender}") we can use this , BUt it is not recommended
	@Autowired
	private NotificationSender sender;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("---- Auto-Wiring Demo ----");
		sender.notifyUser("Nilesh","Hi how are you ? ");
	}
}
