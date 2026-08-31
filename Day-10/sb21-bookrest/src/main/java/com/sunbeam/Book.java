package com.sunbeam;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Book {
	@EqualsAndHashCode.Include
	private int id;
	@NotBlank
	@Length(min = 5)
	private String name;
	@NotBlank
	private String author;
	@NotBlank
	private String subject;
	@Min(0) @Max(5000)
	private double price;
}
