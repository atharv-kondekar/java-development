package com.sunbeam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ai09SimpleRagResumeApplication  implements CommandLineRunner{

	private final AiService aiService;

	Ai09SimpleRagResumeApplication(AiService aiService) {
		this.aiService = aiService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Ai09SimpleRagResumeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int count = 0;
//		count = aiService.addPdfPages("classpath:CV-Atharv-Kondekar.pdf");
		System.out.println("Page added : "+count);
	}
}
