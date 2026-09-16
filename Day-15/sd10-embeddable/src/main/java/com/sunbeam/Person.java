package com.sunbeam;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;

	public Person(int id, String name, int age,String address,int mobile,String email) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.contact = new Contact(address, mobile, email);
	}

	@Embedded
	private Contact contact;
}
