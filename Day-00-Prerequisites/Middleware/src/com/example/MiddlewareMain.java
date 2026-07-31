package com.example;

public class MiddlewareMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object result;
		
		result = Middleware.invoke(
				"com.example.Arithmetic",
				//"add",// 📌 Ans : 30
				//"sub",  // 📌 Ans : -30
				"mul", // ❌ Ans: null - because it is the Private method
					   // 📌 For this we have to use the "m.setAccessible(true);" 
				new Class[] {Integer.class , Integer.class},	
				new Object[] {10,20}
		);
		// This is for the User defined Class
		
		System.out.println("Result : "+result);
		
		// For Default Class of the Java
		result = Middleware.invoke("java.util.Date","toString", null, args);
		System.out.println(result);
				
	}

}
