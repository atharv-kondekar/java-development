package com.sunbeam;

import org.springframework.beans.factory.annotation.Value;

public interface BookProjection {
	int getId();
	double getPrice();

	@Value("#{target.name + ' by '+ target.author }")
	String getNameAuthor();

	@Value("#{ (target.price * args[0]) + target.price }")
	double getPriceAndTax(double taxPrice);

	default double getPriceAndVariableTax() {
		if( getPrice() < 500 )
			return getPrice()*0.05 + getPrice();
		else
			return getPrice()*0.1 + getPrice();
	}
}
