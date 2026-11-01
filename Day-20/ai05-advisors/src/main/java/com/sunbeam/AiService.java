package com.sunbeam;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.stereotype.Service;

@Service
public class AiService {

	private ChatClient chatClient;
	private SimpleLoggerAdvisor simpleLoggerAdvisor;

	public AiService(ChatClient.Builder chatBuilder ) {
		simpleLoggerAdvisor = SimpleLoggerAdvisor.builder().build();
		this.chatClient = chatBuilder
				.defaultSystem("You are the helpful assistant")
				.defaultAdvisors(simpleLoggerAdvisor) //advisor for all the request
				.build();
	}

	public String explain(String topic) {
		String response = chatClient
			.prompt()
			.user( prompt -> prompt
					.text("Explain me {topic} in 5 bullet points")
					.param("topic", topic)
					)
			//.advisors(simpleLoggerAdvisor) //advisor for the current request
			.call()
			.content();

		return response;
	}
}
