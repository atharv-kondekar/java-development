package com.sunbeam;

import java.lang.module.ModuleDescriptor.Builder;
import java.util.Scanner;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ai02GoogleAiApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Ai02GoogleAiApplication.class, args);
	}

	private ChatClient chatClient;

	public Ai02GoogleAiApplication(ChatClient.Builder builder) {
		this.chatClient = builder.build();
	};

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

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
	}}
