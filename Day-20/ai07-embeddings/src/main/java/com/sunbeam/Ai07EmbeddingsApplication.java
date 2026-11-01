package com.sunbeam;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ai07EmbeddingsApplication implements CommandLineRunner {

	private final EmbeddingService embeddingService;

	Ai07EmbeddingsApplication(EmbeddingService embeddingService) {
		this.embeddingService = embeddingService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Ai07EmbeddingsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		String text1 = "I love Soccer";
		float [] vector1 = embeddingService.embed(text1);
		// Vector Represents the Meaning of the Sentence
		System.out.println("Length - "+vector1.length+""
				+ "\nContent - "+Arrays.toString(vector1));

		String text2 = "Football is my favourite sport";
		float [] vector2 = embeddingService.embed(text2);
		System.out.println("Length - "+vector2.length+""
				+ "\nContent - "+Arrays.toString(vector2));

		String text3 = "SpringBoot is popular for the Backend Development";
		float [] vector3 = embeddingService.embed(text3);
		System.out.println("Length - "+vector3.length+""
				+ "\nContent - "+Arrays.toString(vector3));


		System.out.println("Similarity between V1 & V2 : "+
				embeddingService.cosineSimilarity(vector1, vector2));

		System.out.println("Similarity between V2 & V3 : "+
				embeddingService.cosineSimilarity(vector2, vector3));

		System.out.println("Similarity between V1 & V3 : "+
				embeddingService.cosineSimilarity(vector1, vector3));

	}
}
