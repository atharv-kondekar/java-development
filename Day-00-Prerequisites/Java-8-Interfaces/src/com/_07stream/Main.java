package com._07stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {

		String arr[] = { "om" , "ved" , "sai" , "riya"};
		Stream.of(arr)
			.forEach(str->System.out.print(str+" "));

		System.out.println();

		Stream<String> stream = Stream.of("Amit","nitin","nilesh");
		stream.forEach( str -> System.out.print(str+" "));

		System.out.println();

		List<String> list = new ArrayList<>();
		list.add("om");
		list.add("ved");
		list.add("sai");

		list.stream()
			.forEach( s -> System.out.print(s+" "));

		System.out.println();

		int arr2[] = {1,2,3,4,4,5,65,6,7,8,8};

		Arrays.stream(arr2)
			.filter(num -> num % 2==0)
			.forEach(num -> System.out.print(num+" "));

		System.out.println();

		double arr3[] = {23.12,234.3,45,323,78,9};
		Arrays.stream(arr3)
			.filter( num -> num > 90 )
			.forEach( num -> System.out.print(num+" "));
	}
}
