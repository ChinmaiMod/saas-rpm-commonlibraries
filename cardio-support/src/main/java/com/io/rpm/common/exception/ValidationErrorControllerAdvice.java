package com.io.rpm.common.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;

import javax.security.auth.login.CredentialExpiredException;

@ControllerAdvice
public class ValidationErrorControllerAdvice  {

    public ValidationErrorControllerAdvice() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
    }


//    @ExceptionHandler(EntityNotFoundException.class)
//    public ResponseEntity<Object> handleException(RuntimeException exception, WebRequest request) {
//        ValidationError validationError = new ValidationError(exception.getLocalizedMessage(), HttpStatus.NOT_FOUND);
//        validationError.addValidationError(exception.getMessage());
//        return new ResponseEntity<>(validationError, new HttpHeaders(), validationError.getStatus());
//    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Object> handleClientException(HttpClientErrorException exception, WebRequest request) {
        String[] info = exception.getStatusText().split(",");
        String message = String.format("Error with code: %s,[ %s ] was thrown on server %s caused by calling the URL with UUID[%s]",
                exception.getStatusCode(), exception.getLocalizedMessage(), info[1], info[0]);
        ValidationError validationError = new ValidationError(String.format("%s-%s", info[1], info[0]), message, exception.getStatusCode());
        validationError.addValidationError(String.format("%s - %s", exception.getStatusCode(), info[1]));

        return new ResponseEntity<>(validationError, new HttpHeaders(), validationError.getStatus());
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<Object> handleServerException(HttpServerErrorException exception, WebRequest request) {
        String[] info = exception.getStatusText().split(",");
        String message = String.format("Error with code: %s, was thrown on server %s caused by calling the URL with UUID[%s]",
                exception.getStatusCode(), info[1], info[0]);
        ValidationError validationError = new ValidationError(String.format("%s-%s", info[1], info[0]), message, exception.getStatusCode());
        validationError.addValidationError(String.format("%s - %s", exception.getStatusCode(), info[1]));

        return new ResponseEntity<>(validationError, new HttpHeaders(), validationError.getStatus());
    }

    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<Object> handleConflict(RuntimeException exception, WebRequest request) {
        String error = "Illegal argument";
        ValidationError validationError = new ValidationError(exception.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        validationError.addValidationError(error);

        return new ResponseEntity<>(validationError, new HttpHeaders(), validationError.getStatus());
    }
   /* @ExceptionHandler(value = { ClientException.class })
    protected ResponseEntity<Object> gateWayError(RuntimeException exception, WebRequest request) {
        String error = "Gateway Error";
        ValidationError validationError = new ValidationError(exception.getMessage(), HttpStatus.BAD_GATEWAY);
        validationError.addValidationError(error);
        return new ResponseEntity<>(validationError, new HttpHeaders(), validationError.getStatus());
    }*/
    @ExceptionHandler(value = { CredentialExpiredException.class })
    protected ResponseEntity<Object> credentialExpireError(RuntimeException exception, WebRequest request) {
        String error = "Token Expired";
        ValidationError validationError = new ValidationError(exception.getMessage(), HttpStatus.UNAUTHORIZED);
        validationError.addValidationError(error);
        return new ResponseEntity<>(validationError, new HttpHeaders(), validationError.getStatus());
    }
//    @ExceptionHandler({org.hibernate.exception.ConstraintViolationException.class})
//    public ResponseEntity<Object> handleException(org.hibernate.exception.ConstraintViolationException exception, WebRequest request) {
//        ValidationError validationError = new ValidationError(exception.getSQLException().getLocalizedMessage(), HttpStatus.CONFLICT);
//        validationError.addValidationError(exception.getSQLException().getLocalizedMessage());
//
//        return new ResponseEntity<>(validationError, new HttpHeaders(), validationError.getStatus());
//    }

}
