package com.sunbeam;

import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
@SpringBootApplication
public class Sd04QueryMethodsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Sd04QueryMethodsApplication.class, args);
	}

	private BookRepository bookRepository;

	public Sd04QueryMethodsApplication(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hello ");
/*
  		//-------Sort Class---------
		Sort sort1 = Sort.by("price");
		List<Book> books = bookRepository.findAll(sort1);
		for (Book book : books)
			System.out.println(book);
		System.out.println();

		Sort sort2 = Sort.by("name","price");
		books = bookRepository.findAll(sort2);
		for (Book book : books)
			System.out.println(book);
		System.out.println();

		Sort sort3 = Sort.by("price").descending();
		books = bookRepository.findAll(sort3);
		for (Book book : books)
			System.out.println(book);
		System.out.println();

		Sort sort4 = Sort.by("price").descending()
				.and(Sort.by("name").ascending());
		books = bookRepository.findAll(sort4);
		for (Book book : books)
			System.out.println(book);
		System.out.println();
*/
		 Pageable pageDemo1 = PageRequest.of(0, 4);
		 Page<Book> page1 = bookRepository.findAll(pageDemo1);
		 for (Book book : page1.getContent() )
			 System.out.println(book);
		 System.out.println();

		 Pageable pageDemo2 = PageRequest.of(2, 4);
		 Page<Book> page2 = bookRepository.findAll(pageDemo2);
		 for (Book book : page2.getContent() )
			 System.out.println(book);
		 System.out.println();

		 for (int i = 0; i < 3; i++) {
			Sort sort5 = Sort.by("price");

			Pageable pageDemo3 = PageRequest.of(i,4,sort5);
			Page<Book> page3=bookRepository.findAll(pageDemo3);

			for (Book book : page3.getContent())
				System.out.println(book);
		}
 	}
}
