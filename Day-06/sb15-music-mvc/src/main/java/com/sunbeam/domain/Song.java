package com.sunbeam.domain;

import lombok.Data;

@Data
public class Song {
	private int id;
	private String title;
	private String file;
	private String duration;
	private int albumId;
}
