package com.sunbeam;

import java.util.Scanner;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ai01OpenaiGroqApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Ai01OpenaiGroqApplication.class, args);
	}

	private ChatClient chatClient;

	public Ai01OpenaiGroqApplication(ChatClient.Builder builder) {
		this.chatClient = builder.build();
	}


	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("User-> : ");
			String question = sc.nextLine();

			if(question.equals("exit")) {
				break;
			}

			String response =  chatClient
				.prompt().user(question)
				.call()
				.content();
			System.out.println("AI-> : "+response);
		}
	}
}
