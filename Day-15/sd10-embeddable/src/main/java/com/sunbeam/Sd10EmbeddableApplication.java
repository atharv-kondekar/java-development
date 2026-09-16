package com.sunbeam;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sd10EmbeddableApplication implements CommandLineRunner{

	private final PersonRepo personRepo;

	Sd10EmbeddableApplication(PersonRepo personRepo) {
		this.personRepo = personRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(Sd10EmbeddableApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Person p1 = new Person(0,"Nilesh",45,"Pune",12412423,"nilesh@gmail.com");
		personRepo.save(p1);

		List<Person> persons = personRepo.findAll();
		persons.stream()
			.forEach(person -> System.out.println(person));
	}
}
