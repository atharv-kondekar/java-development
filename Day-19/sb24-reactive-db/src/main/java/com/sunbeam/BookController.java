package com.sunbeam;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class BookController {

	private final BookRepo bookRepo;

	BookController(BookRepo bookRepo) {
		this.bookRepo = bookRepo;
	}

	@GetMapping("/books")
	Flux<Book> findAllSubjects(){
		Flux<Book> books = bookRepo.findAll();
		return books;
	}

//	@GetMapping("/books/{id}")
//	//returns Mono when book found otherwise return empty mono
//	Mono<Book> findById(@PathVariable int id){
//		Mono<Book> book = bookRepo.findById(id);
//		return book;
//	}

	@GetMapping("/books/{id}")
	Mono<Book> findById(@PathVariable int id){
		Mono<Book> book = bookRepo
							.findById(id)
							.switchIfEmpty(
									Mono.error(
											new ResponseStatusException(HttpStatusCode.valueOf(404))
									)
							);
		return book;
	}

	@GetMapping("/subjects")
	Flux<String> getSubjects(){
		return bookRepo.distinctSubject();
	}

	@GetMapping("/subjects/{subject}")
	Flux<Book> getBookBySubject(@PathVariable String subject){
		return bookRepo.findBySubject(subject);
	}

	@PostMapping("/books")
	Mono<Book> saveBook(@RequestBody Book book){
		System.out.println(book);

		return bookRepo.save(book);
	}
}
