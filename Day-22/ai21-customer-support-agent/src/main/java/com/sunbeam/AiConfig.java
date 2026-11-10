package com.sunbeam;

import org.springframework.ai.chat.client.advisor.ToolCallAdvisor;
import org.springframework.ai.model.tool.DefaultToolCallingManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

	@Bean
	ToolCallAdvisor.Builder<?> toolCallingAdvisorBuilder(){
		DefaultToolCallingManager manager = DefaultToolCallingManager.builder()
													.maxCallsPerTool(4)
													.maxTotalToolCalls(10)
													.build();
		return ToolCallAdvisor.builder()
					.toolCallingManager(manager);
	}
}
