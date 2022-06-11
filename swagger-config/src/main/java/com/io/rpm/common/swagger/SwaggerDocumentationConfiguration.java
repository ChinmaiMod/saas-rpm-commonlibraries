package com.io.rpm.common.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerDocumentationConfiguration {
    ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Person REST CRUD operations API in Spring-Boot 2")
                .description(
                        "Sample REST API for centalized documentation using Spring Boot and spring-fox swagger 2 ").version("2.0")
                .termsOfServiceUrl("").contact(new Contact("Sandeep Sharma", "", "")).build();
    }
    @Bean
    UiConfiguration uiConfig()
    {
        return UiConfigurationBuilder.builder().supportedSubmitMethods(UiConfiguration.Constants.NO_SUBMIT_METHODS).build();
    }
    @Bean
    public Docket configureControllerPackageAndConvertors() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.io.holter")).build()
                .apiInfo(apiInfo())
                .securitySchemes(Arrays.asList(apiKey()));
    }
    private ApiKey apiKey() {
        return new ApiKey("apiKey", "Authorization", "header");
    }


}
