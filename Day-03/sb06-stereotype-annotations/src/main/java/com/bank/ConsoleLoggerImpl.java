package com.bank;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class ConsoleLoggerImpl implements Logger{
	@Override
	public void log(String message) {
		System.out.println("CONSOLE => "+message);
	}
}
