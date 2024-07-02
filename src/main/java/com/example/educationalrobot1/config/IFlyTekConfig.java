package com.example.educationalrobot1.config;

import com.example.educationalrobot1.client.IFlyTekClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IFlyTekConfig {

    @Value("${iflytek.api.key}")
    private String apiKey;

    @Value("${iflytek.api.secret}")
    private String apiSecret;

    @Bean
    public IFlyTekClient iflyTekClient() {
        return new IFlyTekClient(apiKey, apiSecret);
    }
}
