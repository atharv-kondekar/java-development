package com.sunbeam.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Data
@JsonInclude(Include.NON_NULL)
public class ApiResponse<T> {

	private String status;
	private T data;
	private String message;

	public static <T> ApiResponse<T> sucees(T data){
		return new ApiResponse<>("sucess",data, null);
	}

	public static <T> ApiResponse<T> failure(String message) {
		return new ApiResponse<T>("error", null,message);
	}
}
