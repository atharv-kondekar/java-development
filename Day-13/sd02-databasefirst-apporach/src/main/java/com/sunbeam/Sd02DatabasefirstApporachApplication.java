package com.sunbeam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sd02DatabasefirstApporachApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Sd02DatabasefirstApporachApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("------ Database Forst Apporach ------ ");
		System.out.println("----- Spring Data : Database Initialization-------");
	}
}
