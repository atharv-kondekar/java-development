package com.sunbeam;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@SpringBootApplication
public class Sb07AutowiringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Sb07AutowiringApplication.class, args);
	}

	private  NotificationSender sender;
	//By default @Autowired
	Sb07AutowiringApplication(NotificationSender sender) {
		this.sender = sender;
	}

	@Value("${greet.message}")
	private String message;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(message);
		sender.notify("Nilesh","Hi , How Are you ?");
	}
}
