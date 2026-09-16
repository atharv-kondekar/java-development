package com.sunbeam;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepo extends JpaRepository<Product, Integer> {

	@Query("SELECT b FROM Book b")
	List<Book> findAllBooks();

	@Query("SELECT t FROM Tape t")
	List<Tape> findAllTapes();
}
