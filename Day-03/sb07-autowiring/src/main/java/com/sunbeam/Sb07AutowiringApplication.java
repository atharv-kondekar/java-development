package com.sunbeam;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

	@Autowired
	private NotificationSender sender;

	@Override
	public void run(String... args) throws Exception {
		sender.notify("Nilesh","Hi , How Are you ?");
	}

}
