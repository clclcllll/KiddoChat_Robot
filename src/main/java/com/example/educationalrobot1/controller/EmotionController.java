package com.example.educationalrobot1.controller;

import com.example.educationalrobot1.entity.ImageData;
import com.example.educationalrobot1.entity.EmotionReport;
import com.example.educationalrobot1.service.EmotionAnalysisService;
import com.example.educationalrobot1.service.EmotionReportService;
import com.example.educationalrobot1.service.ImageDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/emotion")
public class EmotionController {

    @Autowired
    private EmotionAnalysisService emotionAnalysisService;

    @Autowired
    private ImageDataService imageDataService;

    @Autowired
    private EmotionReportService emotionReportService;

    @PostMapping("/analyze")
    public Mono<String> analyzeEmotion(@RequestBody String imageData) {
        return emotionAnalysisService.analyzeEmotion(imageData);
    }

    @PostMapping("/detectDanger")
    public Mono<String> detectDangerousBehavior(@RequestBody String imageData) {
        return emotionAnalysisService.detectDangerousBehavior(imageData);
    }

    @PostMapping("/uploadImage")
    public ImageData uploadImage(@RequestBody ImageData imageData) {
        return imageDataService.saveImageData(imageData);
    }

    @GetMapping("/getReports")
    public List<EmotionReport> getReports(@RequestParam String userId, @RequestParam String date) {
        return emotionReportService.getReportsByUserIdAndDate(userId, date);
    }

    @GetMapping("/tellStory")
    public Mono<String> tellStory(@RequestParam String userId) {
        return emotionAnalysisService.tellStory(userId);
    }

    @GetMapping("/playMusic")
    public Mono<String> playMusic(@RequestParam String userId) {
        return emotionAnalysisService.playMusic(userId);
    }
}
