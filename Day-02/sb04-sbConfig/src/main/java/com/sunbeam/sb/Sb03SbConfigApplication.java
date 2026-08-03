package com.sunbeam.sb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:bean.xml")
@SpringBootApplication
public class Sb03SbConfigApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Sb03SbConfigApplication.class, args);
	}
	
	// If Want to do something on Console in the MAIN class 
	// Implement "CommandLineRunner" 
	
	@Autowired
	private ApplicationContext ctx;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Spring Boot DI & Config - Demo");
		
		// XML Configuration
		System.out.print("\n XML Configuration");
		Person p1 = (Person) ctx.getBean("p1");
		System.out.println("\n"+p1.toString());

		Account a1 = (Account) ctx.getBean("a1");
		System.out.println(a1);		
		Account a2 = (Account) ctx.getBean("a2");
		System.out.println(a2);
		
		System.out.print("\n\n");
		
		
		//Annotation Configuration
		System.out.println("Annotation Configuration");
		
		Person p2 = (Person) ctx.getBean("p2");
		System.out.println(p2);
		
		Account a3 = (Account) ctx.getBean("a3");
		System.out.println(a3);
		
		Account a4 = (Account) ctx.getBean("a4");
		System.out.println(a4);
		
		// Mixed Configuration
		
//		Account a5 = (Account) ctx.getBean("a5");
//		System.out.println(a5);
		
		System.out.println("\nMixed Configuration ");
		
		Account a6 = (Account) ctx.getBean("a6");
		System.out.println(a6);
		
		Account a7 = (Account) ctx.getBean("a7");
		System.out.println(a7);
	}
}
