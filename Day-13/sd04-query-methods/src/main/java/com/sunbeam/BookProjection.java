package com.sunbeam;

public interface BookProjection {
	String getName();
	String getAuthor();
	Double getPrice();

	default  String getNameAndAuthor() {
		return getName()+" by "+getAuthor();
	}
}
