package com.sunbeam;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Spring02Main {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		BoxImpl b1 = (BoxImpl) ctx.getBean("b1");
		int val1 = b1.calArea();
		System.out.println("Area : "+val1);
		
		BoxImpl b2 = (BoxImpl) ctx.getBean("b2");
		int val2 = b2.calVolume();
		System.out.println("Volume : "+val2);
		
	}

}
