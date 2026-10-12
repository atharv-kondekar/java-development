package com.sunbeam;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import reactor.core.publisher.Mono;

import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler
	Mono<?> handelException(Exception e){
		return Mono.just(
				Map.of(
						"status" ,"error",
						"message", e.getMessage()
					)
				);
	}
}
