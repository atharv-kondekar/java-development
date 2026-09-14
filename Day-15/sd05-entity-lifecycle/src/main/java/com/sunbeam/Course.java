package com.sunbeam;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EntityListeners(CourseEventListener.class)
@Entity
@Table(name="courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private double fees;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;

	public Course(int id, String name, double fees) {
		super();
		this.id = id;
		this.name = name;
		this.fees = fees;
	}
	/*
// Now , these JPA callback methods used to handle
	// 1. Entity Life Cycle events
	// 2. For the ADUIT CHANGES
	@PrePersist
	void prePersist() {
		System.out.println("Pre-Persisit is called()");
	}

	@PostPersist
	void postPersist() {
		this.createdAt=LocalDateTime.now();
		this.modifiedAt=LocalDateTime.now();
		System.out.println("Post-Presisit is Called()");
	}

	@PreUpdate
	void preUpdate() {
		System.out.println("Pre-Update is called()");
	}

	@PostUpdate
	void postUpdate() {
		this.modifiedAt=LocalDateTime.now();
		System.out.println("Post-Update is called()");
	}

	@PreRemove
	void preRemove() {
		System.out.println("Pre-Remove is called()");
	}

	@PostRemove
	void postRemove() {
		System.out.println("Post-Remove is called()");
	}

	@PostLoad
	void postLoad() {
		System.out.println("Post-Load is called()");
	}
*/
}
