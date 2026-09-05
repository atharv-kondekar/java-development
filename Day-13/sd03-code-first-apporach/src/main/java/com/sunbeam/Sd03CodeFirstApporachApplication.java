package com.sunbeam;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sd03CodeFirstApporachApplication implements CommandLineRunner{

	private final BookRepository bookRepository;

	Sd03CodeFirstApporachApplication(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Sd03CodeFirstApporachApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Method1 -> to have default/initial data into db
		//	write code in commandline runner bean to save() sample records.
		//	e.g. bookRepository.save(new Book(...));

		// Method2 -> use data.sql (spring data initialization) to populate sample data.
		//	note: schema.sql is not needed - because tables are created due to ddl-auto=create setting.
		//	data.sql initialization should be done only after all tables are created by ORM.

		// Method3 -> Flyway - library for data migration
		//	we will discuss later.

		List<Book> books= bookRepository.findAll();
		for (Book book : books) {
			System.out.println(book);
		}
	}
}
