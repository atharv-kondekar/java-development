package com.sunbeam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/ai")
public class AiController {

	private final CutomerSupportAgent cutomerSupportAgent;

	AiController(CutomerSupportAgent cutomerSupportAgent) {
		this.cutomerSupportAgent = cutomerSupportAgent;
	}

	@GetMapping("/chat")
	public String chat(@RequestParam String question) {
		return cutomerSupportAgent
				.chat(question);
	}

}
