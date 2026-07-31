package com.example;

import java.lang.reflect.Method;

public class Middleware {
	public static Object invoke(String className , String methodName , Class[]argType , Object[]argsVal) {
		
		//1.Load the Class at 
		//2.Create the Object of the Class Dynamically : without using new operator
		// 			-Is is required for the calling non-static methods also
		
		//3.Find the Method using the method name
		//4.Invoke the Method & Collect Result
		//5. return the Result
		
		try {
			//1. 
			Class c = Class.forName(className);
			//2.
			Object obj = c.newInstance();
			//3.
			Method m = c.getDeclaredMethod(methodName, argType);
				//3.1 For accessing the private methods 
				m.setAccessible(true);
			//4.
			Object result = m.invoke(obj, argsVal);
			//5.
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}
		
	}
}
