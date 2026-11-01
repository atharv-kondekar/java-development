package com.sunbeam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin
@RestController
@RequestMapping("/ai")
public class AiController {

	private final AiService aiService;

	AiController(AiService aiService) {
		this.aiService = aiService;
	}

	@GetMapping("/ask")
	public String askQuestion(@RequestParam String userInput,@RequestParam String user) {
		return aiService.ask(userInput,user);
	}

}
