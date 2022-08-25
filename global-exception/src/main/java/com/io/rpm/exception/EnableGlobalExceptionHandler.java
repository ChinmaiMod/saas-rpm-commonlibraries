package com.io.rpm.exception;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented

@Import({GlobalExceptionHandler.class})
public @interface EnableGlobalExceptionHandler {
}
