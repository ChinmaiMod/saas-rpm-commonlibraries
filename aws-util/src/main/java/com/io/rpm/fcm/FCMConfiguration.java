package com.io.rpm.fcm;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableAsync;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.IOException;

@Slf4j
@Configuration
@EnableAsync
public class FCMConfiguration {
    Logger logger = LoggerFactory.getLogger(FCMConfiguration.class);
    @Bean
    FirebaseMessaging firebaseMessaging() throws IOException {
        GoogleCredentials googleCredentials = GoogleCredentials
                .fromStream(new ClassPathResource("firebase-service-account.json").getInputStream());
        FirebaseOptions firebaseOptions = FirebaseOptions
                .builder()
                .setCredentials(googleCredentials)
                .build();
//        FirebaseApp app = null;
//        if(FirebaseApp.getApps().isEmpty()) {
//            app = FirebaseApp.initializeApp(firebaseOptions, "appName");
//        }else {
//            app = FirebaseApp.initializeApp(firebaseOptions);
//        }
//        
//        return FirebaseMessaging.getInstance(app);
        FirebaseApp app = FirebaseApp.initializeApp(firebaseOptions);
        logger.info("FCM initialized {}",app.getName());
        return FirebaseMessaging.getInstance(app);
    }
}
