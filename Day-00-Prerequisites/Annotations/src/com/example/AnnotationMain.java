package com.example;

import java.lang.annotation.Annotation;

public class AnnotationMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SomeClass.class.getAnnotations();
		// getAnnotations() : Returns Annotations Applied on that class 
		//					 & Also returns Annotation declared form SuperClass
		
		Annotation[] antns = SomeClass.class.getDeclaredAnnotations();
		//getDeclaredAnnotations() :  Returns Annotations Applied on that class
		for(Annotation atn : antns) {
			System.out.println(atn.toString());
		}
		
		System.out.print("\n\n");
		
		// For accessing the Values 
		Annotation[] annotations2 = SomeClass2.class.getDeclaredAnnotations();
		for(Annotation atn : annotations2) {
			if(atn instanceof Readme)
			{
				Readme readme = (Readme)atn;
				System.out.println("Value : "+readme.value() );
				System.out.println("Info : "+readme.info() );
				System.out.println("Author : "+readme.author() );
				
			}
			//System.out.println(atn.toString());
		}
		
		System.out.print("\n\n");
		//Instead of Doing this Stuff 
		Readme readme = SomeClass3.class.getDeclaredAnnotation(Readme.class);
		System.out.println("Value : "+readme.value() );
		System.out.println("Info : "+readme.info() );
		System.out.println("Author : "+readme.author() );
		
		
	}

}
