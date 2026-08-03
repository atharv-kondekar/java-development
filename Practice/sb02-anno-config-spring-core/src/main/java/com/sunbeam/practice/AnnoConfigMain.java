package com.sunbeam.practice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnoConfigMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx 
			= new AnnotationConfigApplicationContext(AnnoConfiguration.class);
		
		BoxImpl b1 = (BoxImpl) ctx.getBean("b1");
		System.out.println("Area : "+b1.calArea());
		
		BoxImpl b2 = (BoxImpl) ctx.getBean("b2");
		System.out.println("Volume : "+b2.calVolume());
	}

}
