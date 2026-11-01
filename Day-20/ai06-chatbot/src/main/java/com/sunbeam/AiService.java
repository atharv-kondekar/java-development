package com.sunbeam;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.stereotype.Service;

@Service
public class AiService {

	private ChatClient chatClient;

	public AiService(ChatClient.Builder builder) {

		MessageWindowChatMemory chatMemory = MessageWindowChatMemory
											.builder()
											.maxMessages(6)
											.build();

		MessageChatMemoryAdvisor advisor = MessageChatMemoryAdvisor
											.builder(chatMemory)
											.build();

		this.chatClient = builder
				.defaultSystem("You are the Helpful assistant")
				.defaultAdvisors(advisor)
				.build();
	}

	public String ask(String userInput,String userName) {
		String response = chatClient
			.prompt()
			.user(userInput)
			.advisors(adv -> adv.param(ChatMemory.CONVERSATION_ID,userName))
			.call()
			.content();

		return response;
	}
}
