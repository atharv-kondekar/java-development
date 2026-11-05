package com.sunbeam;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AiService {

	private ChatClient chatClient;

	public AiService(ChatClient.Builder builder , ArithmeticTool arithmeticTool
					,WeatherTool weatherTool) {
		this.chatClient = builder
				.defaultTools(arithmeticTool,weatherTool)
				.build();
	}

	public String chat(String question) {
		return chatClient.prompt()
			.user(question)
			.call()
			.content();
	}
}
