 package com.sunbeam;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class Sd13PrimarykeyProjApplication implements CommandLineRunner{

	private final BookDao bookDao;
	private final BookRepo bookRepo;

	Sd13PrimarykeyProjApplication(BookRepo bookRepo, BookDao bookDao) {
		this.bookRepo = bookRepo;
		this.bookDao = bookDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(Sd13PrimarykeyProjApplication.class, args);
	}


	private void initData() {
		bookRepo.save(new Book(0, "Effective Java", "Joshua Bloch", "Java", 550.0));
		bookRepo.save(new Book(0, "Head First Java", "Kathy Sierra", "Java", 480.0));
		bookRepo.save(new Book(0, "Clean Code", "Robert C. Martin", "Java", 620.0));
		bookRepo.save(new Book(0, "Java: The Complete Reference", "Herbert Schildt", "Java", 700.0));
		bookRepo.save(new Book(0, "Spring in Action", "Craig Walls", "Spring", 680.0));
		bookRepo.save(new Book(0, "Spring Boot in Action", "Craig Walls", "Spring Boot", 590.0));
		bookRepo.save(new Book(0, "Head First Design Patterns", "Eric Freeman", "Design Patterns", 750.0));
		bookRepo.save(new Book(0, "Design Patterns", "Erich Gamma", "Design Patterns", 800.0));
		bookRepo.save(new Book(0, "The C Programming Language", "Brian Kernighan", "C", 350.0));
		bookRepo.save(new Book(0, "C Programming: A Modern Approach", "K. N. King", "C", 520.0));
		bookRepo.save(new Book(0, "Let Us C", "Yashavant Kanetkar", "C", 300.0));
		bookRepo.save(new Book(0, "Python Crash Course", "Eric Matthes", "Python", 650.0));
		bookRepo.save(new Book(0, "Fluent Python", "Luciano Ramalho", "Python", 850.0));
		bookRepo.save(new Book(0, "Introduction to Algorithms", "Thomas H. Cormen", "Algorithms", 950.0));

		// for UUID @Id generation
//		bookRepo.save(new Book(null, "Effective Java", "Joshua Bloch", "Java", 550.0));
//		bookRepo.save(new Book(null, "Head First Java", "Kathy Sierra", "Java", 480.0));
//		bookRepo.save(new Book(null, "Clean Code", "Robert C. Martin", "Java", 620.0));
	}

	@Override
	//@Transactional
	public void run(String... args) throws Exception {
		initData();

//		System.out.println("---------------- All Books ----------------");
//		List<Book> books = bookRepo.findAll();
//		books.stream()
//			.forEach(book -> System.out.println(book));
//
//		Double price = bookDao.getBookPrice(1);
//		System.out.println(price);

		List<BookProjection> bookProjections = bookRepo.findBySubject("Java");
		bookProjections.stream()
			.forEach(bookProjection -> System.out.println(bookProjection.getId() +  " " + bookProjection.getPrice()+
				"-----> "+bookProjection.getNameAuthor() + ", \n\tIncluding Tax : "+bookProjection.getPriceAndTax(0.05)
			));

		System.out.println("------------------------------------------------------------------------");

		List<BookProjection>list = bookRepo.getAllBooks();
		list.stream()
			.forEach( book -> System.out.println(book.getNameAuthor() + "     \n           ---->    " + book.getPriceAndVariableTax()));
	}
}
