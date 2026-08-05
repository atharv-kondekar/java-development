package com.sunbeam.bank;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class ConsoleLogger implements Logger{
	@Override
	public void log(String msg) {
		System.out.println("CONSOLE => "+msg);
	}
}
