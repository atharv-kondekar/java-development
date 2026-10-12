package com.sunbeam;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Flux;



public interface BookRepo extends R2dbcRepository<Book, Integer>{

	Flux<Book> findBySubject(String subject);

	@Query("SELECT DISTINCT subject FROM rebooks")
	Flux<String> distinctSubject();
}
