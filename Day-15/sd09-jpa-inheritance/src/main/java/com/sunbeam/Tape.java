package com.sunbeam;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DiscriminatorValue("Tape")
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Data
public class Tape extends Product{
	@Column(name="creator")
	private String artist;
	private int duration;

	public Tape(int id,String name, double price,String artist, int duration,Publisher publisher) {
		super(id,name,price,publisher);
		this.artist = artist;
		this.duration = duration;
	}
}
