package com.sunbeam;

import java.time.LocalDateTime;

import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class CourseEventListener {

	@PrePersist
	void presPersist(Course c) {
		c.setCreatedAt( LocalDateTime.now() );
		c.setModifiedAt( LocalDateTime.now() );
		System.out.println("Pre-Persist is called()");
	}

	@PreUpdate
	void preUpdate(Course c) {
		c.setModifiedAt( LocalDateTime.now());
		System.out.println("Pre-Update is Called()");
	}
}