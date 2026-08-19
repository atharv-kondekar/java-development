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
@RequestMapping("/v4/books")
public class BookRestControllerV4 {

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
	public  ResponseApi<List<Book>> findAll() {
		return ResponseApi.success(list);
	}

	@GetMapping("/{id}")
	public ResponseApi<Book> findById( @PathVariable int id) {
		for (Book book : list) {
			if(book.getId() == id) {
				return  ResponseApi.success(book);
			}
		}
		return ResponseApi.error("Not found");
	}

	@PostMapping
	public ResponseApi<Book> addBook(@RequestBody Book book) {
		list.add(book);
		return ResponseApi.success(book);
	}

	@DeleteMapping("/{id}")
	public ResponseApi<Book> deleteBook(@PathVariable int id) {
		for (Book book : list) {
			if(book.getId() == id) {
				list.remove(book);
				return ResponseApi.success(book);
			}
		}
		return ResponseApi.error("Not Found");
	}

	@PutMapping("/{id}")
	public ResponseApi<Book> editBook(@PathVariable int id ,@RequestBody Book b ) {

		for (int i = 0; i < list.size(); i++) {
			Book book = list.get(i);
			if ( book.getId() == id ) {
				list.set(i, b);
				return ResponseApi.success(book);
			}
 		}

		return ResponseApi.error("Not Found");
	}

	@PatchMapping("/{id}")
	public ResponseApi<Book> updateBookPrice(@PathVariable int id ,
			@RequestBody BookPriceChange bpc) {
		for (Book book : list) {
			if(book.getId() == id) {
				book.setPrice( bpc.getPrice() );
				return ResponseApi.success(book);
			}
		}
		return ResponseApi.error("Not Found");
	}
}
