package com.sunbeam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tools.jackson.databind.ObjectMapper;

@SpringBootApplication
public class Sb18BookRestApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Sb18BookRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		Book book = new Book(8,"Agnipankh","Dr. APJ Abdul Kalam","Novel",1000.00);

		// @ResponseBody -> Json MessageConverter -> objectMapper.writeValueAsString(...);
		String json = objectMapper.writeValueAsString(book);
		System.out.println(json);


		// @RequestBody -> JSON MessageConverter -> objectMapper.readValue(...);
		Book newBook = objectMapper.readValue(json, Book.class);
		System.out.println(newBook);
	}
}
