package com.io.holter.common.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class ValidationError {

    @JsonInclude(JsonInclude.Include.ALWAYS)
    private List<String> errors = new ArrayList<>();

    private String source;

    private String errorMessage;

    private Instant timestamp;

    private HttpStatus status;

    public ValidationError(String source, String errorMessage, HttpStatus status) {
        this.source = source;
        this.errorMessage = errorMessage;
        this.timestamp = Instant.now();
        this.status = status;
    }

    public ValidationError(String errorMessage, HttpStatus status) {
        this.errorMessage = errorMessage;
        this.timestamp = Instant.now();
        this.status = status;
    }

    public ValidationError(List<String> errors) {
        this.errors = errors;
    }

    public ValidationError(String error) {
        this(Collections.singletonList(error));
    }

    public void addValidationError(String error) {
        errors.add(error);
    }

    public List<String> getErrors() {
        return errors;
    }
}
