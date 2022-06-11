package com.io.rpm.decoder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignErrorDecoder {

    @Bean
    public CustomErrorDecoder controllerErrorDecoder(){
        return new CustomErrorDecoder();
    }

}
