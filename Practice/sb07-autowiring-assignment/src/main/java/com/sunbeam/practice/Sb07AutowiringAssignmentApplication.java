package com.sunbeam.practice;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@SpringBootApplication
public class Sb07AutowiringAssignmentApplication implements CommandLineRunner,
ApplicationContextAware{

	public static void main(String[] args) {
		SpringApplication.run(Sb07AutowiringAssignmentApplication.class, args);
	}


	private ApplicationContext ctx;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ctx=applicationContext;
	}

	@Autowired
	private ReadingSender restSender;

	@Autowired
	@Qualifier("soapSender")
	private ReadingSender sender;

	@Override
	public void run(String... args) throws Exception {
		ReadingSender sender1 = ctx.getBean(ReadingSender.class);
		sender1.send();

		// We can use like that also
		//ReadingSender sender2 = ctx.getBean(TcpSender.class);
		ReadingSender sender2 = (ReadingSender) ctx.getBean("tcpSender");
		sender2.send();

		restSender.send();

		sender.send();
	}
}
