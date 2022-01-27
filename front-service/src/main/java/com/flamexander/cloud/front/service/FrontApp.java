package com.flamexander.cloud.front.service;
// html и js стучатся в FrontApp, ктороый через эврику, запрашивать продукты
// и возвращать их, чтобы отрисовать их в html

// т е фронт стучится через свой бэк, который через эврику находит свой продуктовый
// сервис, ищет продукты и отдает их обратно

// тоже должен быть клиентом эврики

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController


public class FrontApp {

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(FrontApp.class, args);
    }

    @GetMapping("/api/v1/product-service/findAll")
    public String getSlowGreetings() {
        String data = restTemplate.getForObject("http://slow-service/api/v1/slow", String.class);
        return "Hello my friend: " + data;
    }
}
