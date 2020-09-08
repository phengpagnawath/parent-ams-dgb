package com.wath.asmapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfigration {

    @Bean
    public OpenAPI customApi(){
        return new OpenAPI().info(new Info().title("DGB API").version("API version 0.0.1").description("Api for DGB"));
    }

}