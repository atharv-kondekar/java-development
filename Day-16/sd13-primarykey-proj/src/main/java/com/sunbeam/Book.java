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

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "books")
public class Book {


	//@GeneratedValue(strategy = GenerationType.IDENTITY)

//	@SequenceGenerator(
//			name = "gen",
//			sequenceName = "books_seq",
//			//allocationSize = 1,
//			allocationSize = 5,
//			initialValue = 10
//	)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen")

//	@GeneratedValue(strategy = GenerationType.AUTO)// For MySQL 8.x, the default strategy used by Hibernate is SEQUENCE
	//	default seq name = tablename_seq, initial value = 1, allocation size = 50

	@TableGenerator(name = "tbgen" , table = "ids_seq")
	@GeneratedValue(strategy = GenerationType.TABLE,generator = "tbgen")
	@Id
	private int id;

//	@Id
//	@GeneratedValue(strategy = GenerationType.UUID)
//	private String id;
	private String name;
	private String author;
	private String subject;
	private double price;
}
