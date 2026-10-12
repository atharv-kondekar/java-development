package com.sunbeam;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rebooks")
public class Book {
	@Id
	int id;
	private String name;
	private String author;
	private String subject;
	private double price;
}
