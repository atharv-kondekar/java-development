package com.example02;

import java.lang.reflect.Method;

public class Middleware {
	
	public static Object invoke(Object obj , String mthdName , Class[]argType,Object[]argVal) {
		
		try {
			Class c = obj.getClass();
			
			//Object obj = c.getDeclaredConstructor().newInstance();
			
			Method m = c.getDeclaredMethod(mthdName,argType);
			
			Object result = m.invoke(obj, argVal);
			
			return result;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
