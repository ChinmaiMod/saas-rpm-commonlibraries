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


@Slf4j
@Configuration
@EnableEncryptableProperties
@EnableAsync
public class S3Configuration {
    @Autowired
    private AwsCredentidal credentidal;
    @Autowired
    AwsProfileManager awsProfileManager;

    @Bean
    public AmazonS3 createS3() {
        if (this.credentidal.getRegion() == null || this.credentidal.getSecretKey() == null || this.credentidal.getAccessKey() == null) {
            log.warn("Cannot initialize S3 client with region: {} accessKey: {} secretKey: {}", this.credentidal.getRegion(), this.credentidal.getAccessKey(),
                    credentidal.getSecretKey());
        }
        //log.info("Access key and secret read from instance:  accessKey: {} secretKey: {}", InstanceProfileCredentialsProvider.getInstance().getCredentials().getAWSAccessKeyId(), InstanceProfileCredentialsProvider.getInstance().getCredentials().getAWSSecretKey());
        AmazonS3 s3client = AmazonS3ClientBuilder.standard().withRegion(this.credentidal.getRegion())
                .withCredentials(new InstanceProfileCredentialsProvider(true))
                .build();
        return s3client;
    }
}