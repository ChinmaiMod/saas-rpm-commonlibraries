package com.io.rpm.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorResponse extends RuntimeException{
	private static final long serialVersionUID = 1L;
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String path;
    private Object obj;
    
	public ErrorResponse() {
		super();
	}
	 
	public ErrorResponse(LocalDateTime timestamp, String error, int status ) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
	}
}