package com.grocery.diff;

import com.grocery.diff.service.ResponseEntityErrorHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class GrodiffApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrodiffApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new ResponseEntityErrorHandler());
        return restTemplate;
    }
}
