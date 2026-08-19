package com.sunbeam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor
@Data
public class Book {
	private int id;
	private String name;
	private String author;
	private String subject;
	private double price;
}
