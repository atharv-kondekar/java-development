package com.sunbeam;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDTO {

	private String name;
	private String subject;
	private double price;
}
