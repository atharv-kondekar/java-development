package com.sunbeam;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Student {
	@EmbeddedId
	private StdRoll stdRoll;
	private String name;
	private int marks;
	public Student(int std,int roll, String name, int marks) {
		super();
		this.stdRoll = new StdRoll(std, roll);
		this.name = name;
		this.marks = marks;
	}


}
