package com.bank;

public class PersonImpl
implements Person{
	private String name;
	private String email;
	private int age;
	public PersonImpl() {
		super();
	}
	public PersonImpl(String name, String email, int age) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "PersonImpl [name=" + name + ", email=" + email + ", age=" + age + "]";
	}


}
