package com.sunbeam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/ai")
public class AiController {

	private final AiService aiService;

	AiController(AiService aiService) {
		this.aiService = aiService;
	}

	@GetMapping("/explain")
	public String getExplain(@RequestParam String topic) {
		return aiService.explain(topic);
	}

}
