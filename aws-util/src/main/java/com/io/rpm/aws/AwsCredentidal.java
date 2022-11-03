package com.io.rpm.aws;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "cardio.config.aws")
public class AwsCredentidal {
    private String region;
    private String accessKey;
    private String secretKey;
    private String profileName;
}