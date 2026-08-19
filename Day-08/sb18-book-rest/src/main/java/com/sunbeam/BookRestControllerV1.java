package com.sunbeam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Controller;

import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BookRestControllerV1 {

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

	@RequestMapping(value="/books", method=RequestMethod.GET)
	public @ResponseBody List<Book> findAll() {
		return list;
	}

	@RequestMapping(value = "/books/{id}",method = RequestMethod.GET)
	public @ResponseBody Book findById( @PathVariable("id") int id) {
		for (Book book : list) {
			if(book.getId() == id) {
				return book;
			}
		}
		return null;
	}

	@RequestMapping(value = "/books",method = RequestMethod.POST)
	public @ResponseBody Book addBook(@RequestBody Book book) {
		list.add(book);
		return book;
	}

	@RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Book deleteBook(@PathVariable("id") int id) {
		for (Book book : list) {
			if(book.getId() == id) {
				list.remove(book);
				return book;
			}
		}
		return null;
	}

	@RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
	public @ResponseBody Book editBook(@PathVariable("id") int id ,@RequestBody Book b ) {

		for (int i = 0; i < list.size(); i++) {
			Book book = list.get(i);
			if ( book.getId() == id ) {
				list.set(i, b);
				return b;
			}
 		}

		return null;
	}

	@RequestMapping(value = "/books/{id}" , method = RequestMethod.PATCH)
//	public @ResponseBody Book updateBookPrice(@PathVariable("id") int id ,
//	@RequestBody double price) { .... }

	// (@RequestBody double price)
	// 		-> "Spring, I am expecting only a number from the request body."
	// 		->	You told me to put the request body into a double, but you sent me an object.
	// 		->	JSON object : {"price": 999.00 }
	// 		-> I can't convert this whole object into a double.

	public @ResponseBody Book updateBookPrice(@PathVariable("id") int id ,
			@RequestBody BookPriceChange bpc) {
		for (Book book : list) {
			if(book.getId() == id) {
				book.setPrice( bpc.getPrice() );
				return book;
			}
		}
		return null;
	}
}
