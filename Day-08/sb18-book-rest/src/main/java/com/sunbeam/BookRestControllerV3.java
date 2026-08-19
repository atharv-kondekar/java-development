package com.sunbeam;

import java.util.ArrayList;
import java.util.List;
import jakarta.annotation.PostConstruct;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v3/books")
public class BookRestControllerV3 {

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

	@GetMapping
	public  ResponseEntity<List<Book>> findAll() {
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> findById( @PathVariable int id) {
		for (Book book : list) {
			if(book.getId() == id) {
				return  ResponseEntity.ok(book);
			}
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		list.add(book);
		return new ResponseEntity<Book>(book,HttpStatusCode.valueOf(201));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable int id) {
		for (Book book : list) {
			if(book.getId() == id) {
				list.remove(book);
				return ResponseEntity.ok(book);
			}
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Book> editBook(@PathVariable int id ,@RequestBody Book b ) {

		for (int i = 0; i < list.size(); i++) {
			Book book = list.get(i);
			if ( book.getId() == id ) {
				list.set(i, b);
				return ResponseEntity.ok(book);
			}
 		}

		return ResponseEntity.notFound().build();
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Book> updateBookPrice(@PathVariable int id ,
			@RequestBody BookPriceChange bpc) {
		for (Book book : list) {
			if(book.getId() == id) {
				book.setPrice( bpc.getPrice() );
				return ResponseEntity.ok(book);
			}
		}
		return ResponseEntity.notFound().build();
	}
}
