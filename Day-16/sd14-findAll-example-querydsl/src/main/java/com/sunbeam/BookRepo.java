package com.sunbeam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BookRepo extends JpaRepository<Book, Integer>,QuerydslPredicateExecutor<Book>{

}
