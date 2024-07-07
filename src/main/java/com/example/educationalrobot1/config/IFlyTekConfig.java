package com.example.educationalrobot1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class IFlyTekConfig {

    @Value("${iflytek.api.key}")
    private String apiKey;

    @Value("${iflytek.api.secret}")
    private String apiSecret;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://api.xfyun.cn/v1/service/v1/spark")
                .defaultHeader("Content-Type", "application/json")
                .defaultHeader("Authorization", "Bearer " + apiKey + ":" + apiSecret)
                .build();
    }
}
