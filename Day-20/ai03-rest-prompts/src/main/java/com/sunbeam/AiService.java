package com.sunbeam;

import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class AiService {

	private ChatClient chatClient;
	private PromptTemplate promptTemplate;


	public AiService(
			ChatClient.Builder builder,
			@Value("classpath:prompts/explain-tech.txt") Resource resource
	) {
		this.chatClient = builder
				.defaultSystem("You are helpful assistant") // global behavior for all request
				.build();

		promptTemplate = new PromptTemplate(resource);
	}

	public String ask(String question) {
		String response = chatClient
			.prompt()
			//.system("You are experienced java developer") //behavior for the current request
			.user(question)
			.call()
			.content();

		return response;
	}

	public ChatResponse askInfo(String question) {
		ChatResponse response = chatClient
				.prompt()
				.user(question)
				.call()
				.chatResponse();

		return response;
	}

	public Flux<String> askLive(String question) {
		Flux<String> response = chatClient
				.prompt()
				.user(question)
				.stream()
				.content();

		return response;
	}

	public String explain(String topic) {
		String promptTemplate = "Explain me {topic} in 5 bullet points";

		String response = chatClient
			.prompt()
			.user( prompt  -> prompt
					.text(promptTemplate)
					.param("topic",topic)
				)
			.call()
			.content();

		return response;
	}

	public String explainTech (String tech, String topic) {
//
//		String path = "prompts/explain-tech.txt";
//		ClassPathResource resource = new ClassPathResource(path);
//
//		String response= chatClient
//			.prompt()
//			.user( prompt -> prompt
//					.text(resource)
//					.param("tech",tech)
//					.param("topic", topic)
//			)
//			.call()
//			.content();
//
//		return response;

		String prompt = promptTemplate.render(Map.of("tech",tech, "topic", topic) );
		String response = chatClient
					.prompt()
					.user(prompt)
					.call()
					.content();
		return response;
	}
}
