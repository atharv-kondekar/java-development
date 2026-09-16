package com.sunbeam;

import jakarta.persistence.AssociationOverride;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book1")
@Data
@NoArgsConstructor
@AssociationOverride(
		name ="publisher",
		joinColumns = @JoinColumn(name="publisher_id")
)
public class Book extends Product{
	private String author;
	private int pages;

	public Book(int id,String name, double price, String author, int pages,Publisher publisher) {
		super(id,name,price,publisher);
		this.author = author;
		this.pages = pages;
	}
}
