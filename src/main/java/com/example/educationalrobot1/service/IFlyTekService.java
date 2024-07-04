package com.example.educationalrobot1.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class IFlyTekService {

    @Value("${79b77970}")
    private String apiKey;

    @Value("${MWU0OTA4YmZlZmE5ZDdiNTg2MmYwOWJk}")
    private String apiSecret;

    private final RestTemplate restTemplate;

    public IFlyTekService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String callSparkModel(String inputText) {
        String apiUrl = "https://spark-api-open.xf-yun.com/v4.0/chat/completions"; // 替换为实际API URL

        // 构建请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey + ":" + apiSecret);

        // 构建请求体
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "generalv4.0");
        Map<String, String> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", inputText);
        requestBody.put("messages", new Map[]{message});

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, requestEntity, String.class);

        return response.getBody();
    }
}
