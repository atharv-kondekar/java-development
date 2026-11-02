package com.sunbeam;

import java.util.List;

import org.springframework.ai.document.Document;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ai08SimpleRagApplication implements CommandLineRunner {

	private final AiService aiService;


	Ai08SimpleRagApplication(AiService aiService) {
		this.aiService = aiService;
	}


	public static void main(String[] args) {
		SpringApplication.run(Ai08SimpleRagApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		//aiService.initStore();

		String question = "Water boils at how much tempeature ?";
		//List<Document> documents = aiService.search(question, 5, 0.5);
		List<Document> documents = aiService.search(question, 5, 0.6);

		System.out.println("Documents Retrived : "+documents.size());
		for (Document document : documents) {
			System.out.println(document.getText());
		}
	}
}
