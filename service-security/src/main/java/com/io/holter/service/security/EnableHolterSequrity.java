package com.io.holter.service.security;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented

@Import(JwtTokenWebSecurityConfigureAdapter.class)
@Configuration
public @interface EnableHolterSequrity {
}
