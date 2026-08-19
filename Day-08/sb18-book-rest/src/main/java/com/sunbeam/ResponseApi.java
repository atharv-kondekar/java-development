package com.sunbeam;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseApi<T> {

	private String status;
	private T data;
	private String message;

	public static <T> ResponseApi<T> success(T data){
		return new ResponseApi<>("Success", data,null);
	}

	public static <T> ResponseApi<T> error(String message) {
		return new ResponseApi<>("fail",null, message);
	}
}
