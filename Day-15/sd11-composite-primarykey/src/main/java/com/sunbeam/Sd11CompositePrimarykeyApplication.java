package com.sunbeam;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sd11CompositePrimarykeyApplication implements CommandLineRunner {

	private final StudentRepo studentRepo;

	Sd11CompositePrimarykeyApplication(StudentRepo studentRepo) {
		this.studentRepo = studentRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(Sd11CompositePrimarykeyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Student s1 = new Student(1, 1,"Soham", 87);
		Student s2 = new Student(1, 2,"Sakshi", 86);
		Student s3 = new Student(1, 3,"Prisha", 89);
		Student s4 = new Student(2, 1,"Madhura", 93);

		studentRepo.save(s1);
		studentRepo.save(s2);
		studentRepo.save(s3);
		studentRepo.save(s4);

		List<Student> students = studentRepo.findAll();
		students.stream()
			.forEach(student -> System.out.println(student));
	}
}
