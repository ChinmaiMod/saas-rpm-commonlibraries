package com.io.rpm.aws;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSCredentialsProviderChain;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AwsProfileManager {

    public AWSCredentialsProvider amazonAWSCredentialsProvider(String profileName) {
        List<AWSCredentialsProvider> providers = new ArrayList<>();

        providers.add(new ProfileCredentialsProvider(profileName));
        providers.add(new DefaultAWSCredentialsProviderChain());

        return new AWSCredentialsProviderChain(
                providers.toArray(new AWSCredentialsProvider[providers.size()]));
    }
}