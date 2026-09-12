package com.sunbeam;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
	public void run(String... args) throws Exception {
		Course c1 = new Course(0, "SB-04", 14000.0);
		courseRepo.save(c1);
		Course c2 = new Course(0, "AI-04", 15000.0);
		courseRepo.save(c2);

		List<Course> courseList = courseRepo.findAll();
		for (Course c : courseList)
			System.out.println(c);
	}

}
