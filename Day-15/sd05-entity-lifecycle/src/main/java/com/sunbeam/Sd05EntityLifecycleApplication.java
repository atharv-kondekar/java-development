package com.sunbeam;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class Sd05EntityLifecycleApplication implements CommandLineRunner{

	private final CourseRepository courseRepo;
	//@Autowired
	Sd05EntityLifecycleApplication(CourseRepository courseRepository) {
		this.courseRepo = courseRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Sd05EntityLifecycleApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		System.out.println();
		Scanner sc = new Scanner(System.in);

		Course c1 = new Course(0, "SB-04", 14000.0);
		courseRepo.save(c1);
		Course c2 = new Course(0, "AI-04", 15000.0);
		courseRepo.save(c2);

		List<Course> courseList = courseRepo.findAll();
		for (Course c : courseList)
			System.out.println(c);

		System.out.println("Enter the id : ");
		int id = sc.nextInt();
		System.out.println("Enter Fees : ");
		double fees = sc.nextDouble();

		Optional<Course> op =courseRepo.findById(id);
		if(op.isPresent()) {
			c1=op.get();
			c1.setFees(fees);
			//courseRepo.save(c1);
		}else {
			System.out.println("Not Found !!!");
		}

		courseList = courseRepo.findAll();
		for (Course c : courseList)
			System.out.println(c);
	}

}
