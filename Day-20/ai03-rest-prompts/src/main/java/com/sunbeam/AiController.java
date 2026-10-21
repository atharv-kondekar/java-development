package com.sunbeam;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai")
public class AiController {


	private final AiService aiService;

	AiController(AiService aiService) {
		this.aiService = aiService;
	}

	@GetMapping("/chat")
	public String ask(@RequestParam String question) {
		return aiService.ask(question);
	}

	@GetMapping("/chatInfo")
	public ChatResponse askInfo(@RequestParam String question) {
		return aiService.askInfo(question);
	}

	@GetMapping(value =  "/chatlive", produces =  MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<String> askLive(@RequestParam String question){
		return aiService.askLive(question);
	}

	@GetMapping("/explain")
	public String explain(@RequestParam String topic) {
		return aiService.explain(topic);
	}

	@GetMapping("/explaintech")
	public String explainTech(@RequestParam String tech, @RequestParam String topic) {
		return aiService.explainTech(tech, topic);
	}

}
