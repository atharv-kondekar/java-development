package com.sunbeam;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tape1")
@NoArgsConstructor
@AllArgsConstructor
public class Tape extends Product{
	private String artist;
	private int duration;

	public Tape(int id,String name, double price,String artist, int duration,Publisher publisher) {
		super(id,name,price,publisher);
		this.artist = artist;
		this.duration = duration;
	}
}
