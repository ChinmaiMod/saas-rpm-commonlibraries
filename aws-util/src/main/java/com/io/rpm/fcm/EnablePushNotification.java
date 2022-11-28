package com.io.rpm.fcm;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented

@Import({FCMConfiguration.class})
public @interface EnablePushNotification {
}