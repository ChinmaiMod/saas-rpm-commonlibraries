package com.io.rpm.aws;

import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ses.SesClient;


@Slf4j
@Configuration
@EnableEncryptableProperties
@EnableAsync
public class SESConfiguration {
    @Autowired
    private AwsCredential credential;
    @Autowired
    AwsProfileManager awsProfileManager;

    @Bean
    public SesClient createSES() {
        checkCred();
        SesClient client = SesClient.builder()
                .region(Region.of(this.credential.getRegion()))
                .credentialsProvider(ProfileCredentialsProvider.create())
                .build();
        return client;
    }

    private void checkCred(){
        if (this.credential.getRegion() == null || this.credential.getSecretKey() == null || this.credential.getAccessKey() == null) {
            log.info("Cannot initialize S3 client with region: {} accessKey: {} secretKey: {}", this.credential.getRegion(), this.credential.getAccessKey(), credential.getSecretKey());
        }
    }
}