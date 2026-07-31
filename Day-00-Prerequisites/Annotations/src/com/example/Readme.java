package com.example;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

// Meta Annotations
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE})
//@Target(value = {ElementType.TYPE ,ElementType.FIELD , ElementType.METHOD , ElementType.CONSTRUCTOR})
public @interface Readme {
	// It can have the multiple members 
	//Implicit Member is
	String value();
	String info() default "No info";
	String author() default "Unknown";
	// ONe member value() is compulsory & info and author is not
}
