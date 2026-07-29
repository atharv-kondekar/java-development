package com.example;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ReflectionMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the Fully Qualified Class name : ");
		String name = sc.nextLine();
		
		try {
			Class c = Class.forName(name);
			System.out.println(c.getName());
			
			Class superCls = c.getSuperclass();
			
			if(superCls != null) {
				System.out.println(superCls.getName());
			}
			
			Class intrf[] = c.getInterfaces();
			for(Class ic : intrf ) {
				System.out.println(ic.getName());
			}
			
			Field[] feilds = c.getDeclaredFields();
			for(Field f : feilds) {
				System.out.println(f.toString());
			}
			
			Constructor ctrs[] = c.getDeclaredConstructors();
			for(Constructor ctr : ctrs) {
				System.out.println(ctr.toString());
			}
			
			Method[] mthds = c.getMethods();
			for(Method mthd : mthds) {
				System.out.println(mthd.toString());
			}
			
			Annotation []anns = c.getAnnotations();
			for(Annotation ann : anns) {
				System.out.print(ann.toString()); // NO Annotations for the java.util.Date , 
				// For Annotation write the your Own Custom Class
			}
 		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sc.close();
	}

}
