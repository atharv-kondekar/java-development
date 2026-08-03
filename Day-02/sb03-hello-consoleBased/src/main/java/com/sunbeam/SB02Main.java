package com.sunbeam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SB02Main implements CommandLineRunner {

	public static void main(String[] args) {
		//System.out.println("Hello World"); // Writing here is bad
		// Because the main() is entry point of the JVM 
		SpringApplication.run(SB02Main.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World");
	}

}
