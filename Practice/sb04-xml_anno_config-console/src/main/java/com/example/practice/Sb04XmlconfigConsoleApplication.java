package com.example.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 
 	As SpringBoot never allows the XML Configuration
 	so we have to import it */ 
@ImportResource("classpath:beans.xml")
@SpringBootApplication
public class Sb04XmlconfigConsoleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Sb04XmlconfigConsoleApplication.class, args);
	}
	
	@Autowired
	private ApplicationContext ctx;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello Spring Boot");
		
		Person p1 = (Person) ctx.getBean("p1");
		System.out.println(p1);
		Account a1 = (Account) ctx.getBean("a1");
		System.out.println(a1);
		
		System.out.print("\n");
		
		Person p2 =(Person) ctx.getBean("p2");
		System.out.println(p2);
		Account a3 = (Account) ctx.getBean("a3");
		System.out.println(a3);
		Account a4 = (Account) ctx.getBean("a4");
		System.out.println(a4);
		
		
		System.out.println("\n\nNow i want the p1 from beans.xml & a6,a7 from AppConfig\n");
		
//		Account a5 = (Account) ctx.getBean("a5");
//		System.out.println(a5);
		
		Account a6 = (Account) ctx.getBean("a6");
		System.out.println(a6);
		
		Account a7 = (Account) ctx.getBean("a7");
		System.out.print(a7);
	}
}
