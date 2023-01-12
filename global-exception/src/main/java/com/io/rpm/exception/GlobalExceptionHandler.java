package com.io.rpm.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Configuration
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	//CommonsMultipartResolver
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ResponseEntity<ErrorResponse> handleError2(MaxUploadSizeExceededException ex, HttpHeaders headers, WebRequest request) {
		ErrorResponse errors = new ErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError("File size too large! File Size upto 10MB");
		errors.setObj(ex.getMessage());
		errors.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errors.setPath(request.getContextPath());
		log.info("handleError2 Global exception:- "+ex.getMessage());
		return new ResponseEntity(errors, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponse> customException(CustomException ex, WebRequest request,HttpStatus status) {
		ErrorResponse errors = new ErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setObj(ex.getMessage());
		errors.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errors.setPath(request.getContextPath());
		log.info("customException Global exception:- "+ex.getMessage());
		return new ResponseEntity(errors, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", new Date());
		body.put("status", status.value());
		Map<String, String> errors = ex.getBindingResult().getAllErrors().stream()
				.collect(Collectors.toMap(x -> ((FieldError) x).getField(), x -> x.getDefaultMessage()));
		body.put("errors", errors);
		log.info("handleMethodArgumentNotValid Global exception:- "+ex.getMessage());
		return new ResponseEntity<>(body, headers, status);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Map<String, Object>> handleAllExceptions(Exception ex, WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<>();
		StringWriter sw = new StringWriter();
		ex.printStackTrace(new PrintWriter(sw));
		body.put("timestamp", new Date());
		body.put("request", request.getDescription(false));
		body.put("message", "Unexpected Exception");
		body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		body.put("trac", sw.toString());
		ex.printStackTrace();
		log.info("handleAllExceptions Global exception:- "+ex.getMessage());
		return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}