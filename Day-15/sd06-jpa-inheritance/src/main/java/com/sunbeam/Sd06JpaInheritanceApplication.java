package com.sunbeam;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sd06JpaInheritanceApplication implements CommandLineRunner{

	private final PublisherRepo publisherRepo;
	private final ProductRepo productRepo;

	Sd06JpaInheritanceApplication(ProductRepo productRepo, PublisherRepo publisherRepo) {
		this.productRepo = productRepo;
		this.publisherRepo = publisherRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(Sd06JpaInheritanceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		initData();
		findAllBooks();
		findAllTapes();
		//findAllProducts();
	}

	void initData() {

		Publisher pub1 = new Publisher(0,"TMH");
		Publisher pub2 = new Publisher(0,"T-Seris");
		publisherRepo.save(pub1);
		publisherRepo.save(pub2);

		Book b1 = new Book(0, "Java",650.00,"James Goslin",400,pub1);
		Book b2 = new Book(0, "OS",500.00,"Galvin",350,pub1);
		productRepo.save(b1);
		productRepo.save(b2);

		Tape t1 = new Tape(0, "Flute", 200.00,"Hariprasad", 80,pub2);
		Tape t2 = new Tape(0, "Santoor", 220.00,"Shivkumar", 80,pub2);
		productRepo.save(t1);
		productRepo.save(t2);

	}

	void findAllBooks() {
		List<Book> books = productRepo.findAllBooks();
		books.stream()
			.forEach(book -> System.out.println(book));
		System.out.println("--------------------------------------------------------");
	}

	void findAllTapes() {
		List<Tape> tapes = productRepo.findAllTapes();
		tapes.stream()
			.forEach(tape -> System.out.println(tape));
		System.out.println("--------------------------------------------------------");
	}

	void findAllProducts() {
		// JPQL -> SELECT p FROM Product p ----------- Polymorphic Query
		//     "Here the Product is not @Entity"
		// So , on @MappedSuperClass , NO polymorphic Queries Are allowed
		// Exception : Not an Entity com.sunbeam.Product
		List<Product> products = productRepo.findAll();

		products.stream()
			.forEach(product -> System.out.println(product));
		System.out.println("--------------------------------------------------------");
	}
}
