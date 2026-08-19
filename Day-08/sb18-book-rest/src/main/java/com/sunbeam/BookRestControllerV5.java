package com.sunbeam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/v5")
public class BookRestControllerV5 {

	private List<Book> list;

	@PostConstruct
	void init() {
		list = new ArrayList<>();
		list.add(new Book(1, "Effective Java", "Joshua Bloch", "Java Programming", 599.00));
		list.add(new Book(2, "Clean Code", "Robert C. Martin", "Software Engineering", 749.00));
		list.add(new Book(3, "Spring in Action", "Craig Walls", "Spring Framework", 899.00));
		list.add(new Book(4, "Head First Java", "Kathy Sierra", "Java Programming", 650.00));
		list.add(new Book(5, "Database System Concepts", "Abraham Silberschatz", "Database Management", 799.00));
	}

	@GetMapping("/jsonBooks")
	public List<Book> getJsonBooks() {
		return list;
	}

	@GetMapping(value="/xmlBooks",produces="application/xml")
	public List<Book> getXmlBooks() {
		return list;
	}

	@PostMapping(value="/xmlBooks",consumes="application/xml",produces="application/xml")
	public Book addBook( @RequestBody Book book) {
		list.add(book);
		return book;
	}

	@GetMapping(value="/yamlBooks",produces="application/yaml")
	public List<Book> getYamlBooks() {
		return list;
	}

	@GetMapping("/allBooks")
	public List<Book> getAllBooks(){
		return list;
	}

}
