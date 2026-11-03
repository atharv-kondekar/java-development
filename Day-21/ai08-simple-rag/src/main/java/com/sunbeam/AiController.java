package com.sunbeam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class AiController {

	private final AiService aiService;

	AiController(AiService aiService) {
		this.aiService = aiService;
	}

	@GetMapping("/chat")
	public String chat(@RequestParam String question) {
		return aiService.chat(question);
	}
}
