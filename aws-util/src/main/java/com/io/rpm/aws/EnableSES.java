package com.io.rpm.aws;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented

@Import({SESConfiguration.class})
public @interface EnableSES {
}
