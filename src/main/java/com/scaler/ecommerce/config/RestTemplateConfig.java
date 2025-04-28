package com.scaler.ecommerce.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean //creating string annotation and storing it in bean to reuse it after
    public RestTemplate getRestTemplate(){
        return new RestTemplateBuilder().build();
    }
}
