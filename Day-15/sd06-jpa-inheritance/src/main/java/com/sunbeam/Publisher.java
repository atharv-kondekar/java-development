package com.sunbeam;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "publisher1")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Publisher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@Transient
	@OneToMany(mappedBy = "publisher")
	private List<Product> products;

	public Publisher(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.products = new ArrayList<>();
	}
}
