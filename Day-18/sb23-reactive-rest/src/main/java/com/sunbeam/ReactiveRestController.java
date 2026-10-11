package com.sunbeam;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class ReactiveRestController {

	@GetMapping("/")
	public Flux<String> helloReactive(){
		return Flux.just("Hello Reactive programming ......");
	}

	@GetMapping("/flux1")
	public Flux<String> flux1(){
		return Flux.just("A","B","C","D");
	}

	@GetMapping("/flux2")
	public Flux<String> flux2(){
		return Flux
				.just("A","B","C","D","E","F","G","H","I","J","K","L","M","N")
				.delayElements(Duration.ofMillis(500))
				.log();
	}

	@GetMapping(value = "/flux3" , produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<String> flux3(){
		return Flux
				.just("A","B","C","D","E","F","G","H","I","J","K","L","M","N")
				.delayElements(Duration.ofMillis(500))
				.log();
	}

}
