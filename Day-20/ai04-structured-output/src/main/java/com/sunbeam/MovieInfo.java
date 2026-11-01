package com.sunbeam;


import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieInfo {

	private String title;
	private String director;
	private String leadStarCast[];
	private String shortDescription;
	@Nullable private Integer imdbRating;
	@Nullable private double releaseYear;
}
