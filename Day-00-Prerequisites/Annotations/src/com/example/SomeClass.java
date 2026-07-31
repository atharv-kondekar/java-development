package com.example;

@Readme(value = "This is the README Annottaion")
public class SomeClass {

}

@Readme(value = "Class 2" , author="Nilesh")
class SomeClass2 {
	
}

@Readme(value = "Class 3" , author="Nilesh", info="More Info")
class SomeClass3 {
	
}

// What if I give this annotation for the field ?
// Compiler Error
class SomeClass4{
	//@Readme(value="Om") // Gives the Error
	// Annotation declared is only for the class level
	private int id;
}