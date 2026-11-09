package com.sunbeam;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class CutomerSupportAgent {
	private CusomerTool cusomerTool;
	private OrdersTool ordersTool;
	private ChatClient chatClient;

	public CutomerSupportAgent(CusomerTool cusomerTool , OrdersTool ordersTool,
			ChatClient.Builder builder) {
		this.ordersTool = ordersTool;
		this.cusomerTool = cusomerTool;

		this.chatClient = builder
				.defaultSystem("""
						You are the customer support agent.

						Help cutomer with customer information:
						- Customer Information
						- Order Information
						- Order Status
						- Refund Requests

						Always use the available tools when customer or order information
						or necessary actions to be taken on them.


						Be consise and user friendly;
						""")
				//.defaultTools(cusomerTool,ordersTool)
								// Tools will available for every request
				.build();
	}

	public String chat(String question) {

		return chatClient
					.prompt()
					.user(question)
					.tools(ordersTool,cusomerTool)
							// tools available for the Current request
					.call()
					.content();
	}


}
