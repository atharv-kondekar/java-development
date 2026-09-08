package com.sunbeam;

import org.springframework.data.domain.Pageable;

import java.util.Arrays;
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
  		//------ findAll(Sort sort) - PaggingAndSortingRepository --------
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
		//------ findAll(Pageable pageable ) - PaggingAndSortingRepository --------
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
			System.out.println("Page : "+page3.getNumber()+" out of "+page3.getTotalPages());
			for (Book book : page3.getContent())
				System.out.println(book);
		}

		List<Book> books = bookRepository
				.findByPriceBetweenAndNameContainingAndAuthorContainingOrderByPriceDesc(100,600,"a","sawant");
		books.stream()
			.forEach(book->System.out.println(book));
		System.out.println();


		List<String> books1 = bookRepository.nativeQuery1();
		books1.stream()
			.forEach(book -> System.out.println(book));
		System.out.println();

		List<String> books2 = bookRepository.jpqlQuery1();
		books2.stream()
			.forEach( book -> System.out.println(book));
		System.out.println();

		List<Book> books3 = bookRepository.jpqlQuery2(400, 600);
		books3.stream()
			.forEach(book->System.out.println(book));
		System.out.println();

		// Like uses exact matching , For Containing we have to use %
		List<Book> books4 = bookRepository.jpqlQuery3(100,600,"%a%","%sawant%");
		books4.stream()
			.forEach(book->System.out.println(book));
		System.out.println();

		List<Book> books5 = bookRepository.jpqlQuery4();
		books5.stream()
			.forEach(book->System.out.println(book));
		System.out.println();

		List<String> books6 = bookRepository.jpqlQuery5();
		books6.stream()
			.forEach(book->System.out.println(book));
		System.out.println();

		List<BookProjection> books7 = bookRepository.findBySubject("Historical");
		books7.stream()
		.forEach(  /*Open Projection*/
				book -> System.out.println(book.getNameAndAuthor()+" , "+book.getPrice()) );
/*Closed Projection*///.forEach(book->System.out.println(book.getAuthor() + " "+book.getName()+" "+book.getPrice()));
		System.out.println();

		List<BookDTO> books8 = bookRepository.findByPriceLessThan(500);
		books8.stream()
			.forEach(book -> System.out.println(book));
		System.out.println();

		List<BookDTO> books9 = bookRepository.jpqlQuery6();
		books9.stream()
			.forEach(book->System.out.println(book));
		System.out.println();

		List<Object[]> books10 = bookRepository.jpqlQuery7();
		books10.stream()
			.forEach(book->System.out.println( Arrays.toString(book)));
		System.out.println();

		 List<BookProjection> books11 = bookRepository.findByPriceLessThan(500,BookProjection.class);
		 books11.stream()
		 	.forEach(book->System.out.println(book.getNameAndAuthor() +" , "+book.getPrice()));
		 System.out.println();

		 List<BookDTO> books12 = bookRepository.findByPriceLessThan(500,BookDTO.class);
		 books12.stream()
		 	.forEach(book -> System.out.println(book));
		 System.out.println();

//		 int update = bookRepository.updateBookPrice("Historical");
//		 System.out.println(update);
 	}
}
