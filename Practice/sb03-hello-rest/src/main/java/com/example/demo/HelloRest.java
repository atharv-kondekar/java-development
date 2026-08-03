package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRest {
	
	@GetMapping("/hello")
	String helloString() {
		return "Hello Spring Boot";
	}
}
