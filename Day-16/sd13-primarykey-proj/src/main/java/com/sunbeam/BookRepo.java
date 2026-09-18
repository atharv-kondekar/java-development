package com.sunbeam;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface BookRepo extends JpaRepository<Book, Integer>{

	List<BookProjection> findBySubject(String sub);

	@Query("SELECT b FROM Book b")
	List<BookProjection> getAllBooks();
}
