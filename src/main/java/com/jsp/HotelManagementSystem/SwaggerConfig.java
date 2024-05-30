package com.jsp.HotelManagementSystem;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder()
                .group("public-apis")
                .pathsToMatch("/**")
                .build();
    }
    @Bean
    OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(
                        new Info().title("Hotel Management APIs").version("API v1.0")
                );
    }
}
