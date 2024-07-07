package com.example.educationalrobot1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class EmotionAnalysisService {

    @Autowired
    private WebClient webClient;

    public Mono<String> analyzeEmotion(String imageData) {
        return webClient.post()
                .uri("/emotion")
                .bodyValue(imageData)
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> detectDangerousBehavior(String imageData) {
        return webClient.post()
                .uri("/dangerousBehavior")
                .bodyValue(imageData)
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> tellStory(String userId) {
        return webClient.post()
                .uri("/tellStory")
                .bodyValue("{\"userId\":\"" + userId + "\"}")
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> playMusic(String userId) {
        return webClient.post()
                .uri("/playMusic")
                .bodyValue("{\"userId\":\"" + userId + "\"}")
                .retrieve()
                .bodyToMono(String.class);
    }
}
