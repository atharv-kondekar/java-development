package com.sunbeam;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Integer> {
	List<Book> findByPriceBetweenAndNameContainingAndAuthorContainingOrderByPriceDesc(double minPrice,double maxPrice
			,String name,String title);

	//Get the distinct subjects in the database
	// Native Queries (SQL)
	@Query(value="SELECT DISTINCT subject FROM books", nativeQuery = true)
	List<String> nativeQuery1();

	// JPQL
	@Query("SELECT DISTINCT b.subject FROM Book b")
	List<String> jpqlQuery1();

	// Parameter Bindings in JPQL
	// 1.
	@Query("SELECT b FROM Book b WHERE b.price BETWEEN ?1 AND ?2")
	List<Book> jpqlQuery2(double minPrice , double maxPrice);

	//2.
	@Query("SELECT b from Book b WHERE (b.price BETWEEN :mnp AND :mxp) "
			+ "AND (b.name LIKE :nm)"
			+ " AND (b.author LIKE :au)"
	)
	List<Book> jpqlQuery3(@Param("mnp") double minPrice , @Param("mxp") double maxPrice ,
			@Param("nm") String name ,@Param("au") String author);

	@Query("FROM Book b ORDER BY b.price DESC")
	List<Book> jpqlQuery4();

	@Query("SELECT DISTINCT b.author FROM Book b	")
	List<String> jpqlQuery5();

	// Projection
	// 1. Closed projection
	List<BookProjection> findBySubject(String subject);
}
