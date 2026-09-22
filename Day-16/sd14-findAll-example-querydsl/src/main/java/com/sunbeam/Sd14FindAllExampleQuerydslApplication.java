package com.sunbeam;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;


@SpringBootApplication
public class Sd14FindAllExampleQuerydslApplication implements CommandLineRunner{

	private final BookRepo bookRepo;

	Sd14FindAllExampleQuerydslApplication(BookRepo bookRepo) {
		this.bookRepo = bookRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(Sd14FindAllExampleQuerydslApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		initData();
/*
     // ------------ findAll(Example example) --------

		//Example<Book>bookExample = findBySubject("java");
		//Example<Book>bookExample = findByAnyMatcher("java");
		//Example<Book>bookExample = findByExatchField("java");
		//Example<Book>bookExample = findByNameStartingWith("The");

		Example<Book>bookExample = findByNameAndAuthor("Spring Boot in Action", "Craig Walls");
		List<Book> books = bookRepo.findAll(bookExample);
		books.stream()
			.forEach(book -> System.out.println(book));
*/

		System.out.println("---------------------------QueryDsl-----------------------");
		// ------------------ QueryDsl ------------
		QBook book = QBook.book;

		BooleanExpression pred1 = book.author.eq("Craig Walls");
		List<Book> books = (List<Book>) bookRepo.findAll(pred1);
		books.stream()
			.forEach(bk -> System.out.println(bk));
		System.out.println("-----------------------------------------------------------------");

		BooleanExpression pred2 = book.price.between(300, 500);
		books = (List<Book>) bookRepo.findAll(pred2);
		books.stream()
		.forEach(bk -> System.out.println(bk));

		System.out.println("-----------------------------------------------------------------");

		BooleanExpression pred3 = book.price.between(300, 600);
		OrderSpecifier<Double> order = book.price.asc();
		books = (List<Book>) bookRepo.findAll(pred3,order);
		books.stream()
		.forEach(bk -> System.out.println(bk));

	}

	public static Example<Book> findBySubject(String subject) {
		Book ex = new Book();
		ex.setSubject(subject);
		// default matcher is ExampleMatcher.matchAll()
		//from books b1_0 where b1_0.id=? and b1_0.price=? and b1_0.subject=?
		//uses the 'and' operator
		return Example.of(ex);
	}

	public static Example<Book> findByAnyMatcher(String subject){
		Book ex = new Book();
		ex.setSubject(subject);
		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny();
		//from books b1_0 where b1_0.subject=? or b1_0.price=? or b1_0.id=?
		// Uses the 'or' operator for the searching
		return Example.of(ex,exampleMatcher);
	}

	public static Example<Book> findByExatchField(String subject){
		Book ex = new Book();
		ex.setSubject(subject);

		ExampleMatcher matcher = ExampleMatcher.matching()
									.withIgnorePaths("name","id","price","author");
		//from books b1_0 where b1_0.subject=?
		// Uses the Exact Field
		return Example.of(ex,matcher);
	}

	public static Example<Book> findByNameStartingWith(String name) {
		Book ex = new Book();
		ex.setName(name);

		ExampleMatcher matcher = ExampleMatcher.matching()
									.withIgnorePaths("id","price","author","subject")
									.withStringMatcher(StringMatcher.STARTING);
		//from books b1_0 where b1_0.name like ?
		//uses the 'like'
		return Example.of(ex, matcher);
	}

	public static Example<Book> findByNameAndAuthor(String name ,String author) {
		Book ex = new Book();
		ex.setName(name);
		ex.setAuthor(author);

		ExampleMatcher matcher = ExampleMatcher.matching()
									.withIgnorePaths("id","price","subject");
		//from books b1_0 where b1_0.name=? and b1_0.author=?
		//matching() uses the 'and' operator
		return Example.of(ex , matcher);
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
	}
}
