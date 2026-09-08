package com.sunbeam;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

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
	// 1. Closed projection / Open Projection
	List<BookProjection> findBySubject(String subject);

	// 2.Class Based projection
	List<BookDTO> findByPriceLessThan(double price);

	// 3.Class Based projection using JPQL
	@Query("SELECT new com.sunbeam.BookDTO( b.name , b.subject , b.price) FROM Book b")
	List<BookDTO> jpqlQuery6();

	// 4.Untyped Projection
	@Query("SELECT b.subject , COUNT(b.id) ,SUM(b.price) FROM Book b GROUP BY b.subject")
	List<Object[]> jpqlQuery7();

	// 5.Dynamic Projection
	<T> List<T> findByPriceLessThan(double price, Class<T> classInfo);

	// Increase price of the all books by 10% for the Given subject
	@Modifying
//	@Transactional
	@Query("Update Book b SET b.price = b.price*1.1 WHERE b.subject = :sub")
	int updateBookPrice(@Param("sub") String sub);
}
