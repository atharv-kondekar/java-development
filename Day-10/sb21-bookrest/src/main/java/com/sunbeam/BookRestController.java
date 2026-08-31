package com.sunbeam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;

@RequestMapping("/books")
@RestController
public class BookRestController {
	private List<Book> books;
	@PostConstruct
	void init() {
		books = new ArrayList<>();
        books.add(new Book(1, "Chhava", "Shivaji Sawant", "Historical", 450));
        books.add(new Book(2, "Mrityunjay", "Shivaji Sawant", "Historical", 500));
        books.add(new Book(3, "Yugandhar", "Shivaji Sawant", "Mythological", 550));
        books.add(new Book(4, "Shriman Yogi", "Ranjit Desai", "Historical", 480));
        books.add(new Book(5, "Batatyachi Chawl", "P. L. Deshpande", "Humor", 350));
        books.add(new Book(6, "Swami", "Ranjit Desai", "Historical", 400));
        books.add(new Book(7, "Pawankhind", "Ranjit Desai", "Historical", 420));
        books.add(new Book(8, "Raja Ravi Verma", "Ranjit Desai", "Biography", 380));
        books.add(new Book(9, "Yayati", "V. S. Khandekar", "Mythological", 430));
	}
	@GetMapping
	public List<Book> getAllBooks() {
		return books;
	}
	@GetMapping("/{bookId}")
	public Book getBookById(@PathVariable int bookId) {
		for (Book book : books) {
			if(book.getId() == bookId)
				return book;
		}
		return null;
	}
	@GetMapping("/bysubject/{subject}")
	public List<Book> getBooksBySubject(@PathVariable String subject) {
		return books.stream()
				.filter(book -> book.getSubject().equals(subject))
				.toList();
	}
	/*
	@PostMapping
	public Book addBook(@Valid @RequestBody Book book, BindingResult res) {
		if(res.hasErrors()) {
			System.out.println("ERROR: " + res);
			return null;
		}
		books.add(book);
		return book;
	}
	*/
	//Validation using Global Exception Handler
	@PostMapping
	public Book addBook(@Valid @RequestBody Book book) {
		books.add(book);
		return book;
	}
	@PutMapping("/{bookId}")
	public Book updateBook(@PathVariable int bookId, @Valid @RequestBody Book book) {
		Book key = new Book();
		key.setId(bookId);
		int index = books.indexOf(key);
		if(index != -1) {
			book.setId(bookId);
			books.set(index, book);
			return book;
		}
		return null;
	}
	@DeleteMapping("/{bookId}")
	public Book deleteBook(@PathVariable int bookId) {
		Book key = new Book();
		key.setId(bookId);
		int index = books.indexOf(key);
		if(index != -1) {
			Book book = books.get(index);
			books.remove(index);
			return book;
		}
		return null;
	}
}
