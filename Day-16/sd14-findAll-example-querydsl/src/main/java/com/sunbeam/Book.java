package com.sunbeam;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "books")
public class Book {
	@GeneratedValue(strategy = GenerationType.TABLE,generator = "tbgen")
	@Id
	private int id;
	private String name;
	private String author;
	private String subject;
	private double price;
}
