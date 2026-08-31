package com.sunbeam;

import java.sql.Struct;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class Sb21BookrestClientApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Sb21BookrestClientApplication.class, args);
	}

	private RestTemplate restTemplate;
	private RestClient restClient;

	@Autowired
	public Sb21BookrestClientApplication(RestTemplate restTemplate, RestClient restClient) {
		this.restTemplate = restTemplate;
		this.restClient = restClient;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello .....");
/*
		String url = "http://localhost:8081/books/1";
		String response = restTemplate.getForObject(url, String.class);
		System.out.println(response);

		System.out.println("--------------------------------------------------------------------");

 		//GET request by using Book ID
		String url1 = "http://localhost:8081/books/1";
		Book response2 = restTemplate.getForObject(url, Book.class);
		System.out.println(response2);

		System.out.println("--------------------------------------------------------------------");

		//GET request for all Books
		String url2 = "http://localhost:8081/books";
		RequestEntity<Void> req = RequestEntity.get(url2)
									.accept(MediaType.APPLICATION_JSON)
									.build();

		ResponseEntity<List<Book>> res = restTemplate.exchange(
				req,
				new ParameterizedTypeReference<List<Book>>() {}
			);

		if(res.getStatusCode() == HttpStatusCode.valueOf(200)) {
			List<Book> booksList = res.getBody();

			for (Book book : booksList) {
				System.out.println(book);
			}
		}
		else {
			System.out.println("Not found");
		}

		System.out.println("--------------------------------------------------------------------");

		String subject = "Historical";
		String url3 = "http://localhost:8081/books/bysubject/"+subject;
		RequestEntity<Void> req1 = RequestEntity.get(url3)
									.accept(MediaType.APPLICATION_JSON)
									.build();
		ResponseEntity<List<Book>> res1 = restTemplate.exchange(
				req1,
				new ParameterizedTypeReference<List<Book>>() {}
			);

		if( res1.getStatusCode() == HttpStatusCode.valueOf(200)) {
			List<Book> books = res1.getBody();
			for (Book book : books) {
				System.out.println(book);
			}
		}
		else {
			System.out.println("Not found");
		}*/

		System.out.println("------ using RestClient----- ");
/*
		String url = "http://localhost:8081/books/1";
		Book book = restClient.get()
			.uri(url)
			.accept(MediaType.APPLICATION_JSON)
			.retrieve()
			.body(Book.class);
		System.out.println(book);
*/

	/*	String url = "http://localhost:8081/books";
		List<Book> books= restClient.get()
			.uri(url)
			.accept(MediaType.APPLICATION_JSON)
			.retrieve()
			.body( new ParameterizedTypeReference<List<Book>>() {});
		for (Book book : books) {
			System.err.println(book);
		}
	*/
	/*
		String url = "http://localhost:8081/books";
		Book book = new Book(10,"Yugandhar", "Shivaji Sawant", "History",890.77);

		Book book2= restClient.post()
			.uri(url)
			.body(book) //Request Body
			.retrieve()
			.body(Book.class); //Response Body
		System.out.println("Book Saved : "+book2);
	*/
	/*
		String url = "http://localhost:8081/books/11";
		Book book = new Book(10,"Yugandhar", "Shivaji Sawant", "History",999.99);

		Book ub = restClient.put()
			.uri(url)
			.body(book)
			.retrieve()
			.body(Book.class);
		System.out.println("Updated book : "+ub);
	*/
		String url = "http://localhost:8081/books/10";

		Book ub = restClient.delete()
			.uri(url)
			.accept(MediaType.APPLICATION_JSON)
			.retrieve()
			.body(Book.class);

		System.out.println("Deleted book : "+ub);

	}

}
