package com.sunbeam.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Album {
	private int id;
	private String title;
	private String thumbnail;
}
