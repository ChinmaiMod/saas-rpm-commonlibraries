package com.io.rpm.exception;

import lombok.Data;

@Data
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private Object obj;
	
	public CustomException(String message, Object obj) {
		super(message);
		this.obj=obj;
	}
}