package com.example.educationalrobot1.service;

import com.example.educationalrobot1.entity.EmotionReport;
import com.example.educationalrobot1.entity.ImageData;
import com.example.educationalrobot1.repository.EmotionReportRepository;
import com.example.educationalrobot1.repository.ImageDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;  // 确保导入了java.util.List

@Service
public class EmotionReportService {

    @Autowired
    private EmotionAnalysisService emotionAnalysisService;

    @Autowired
    private ImageDataRepository imageDataRepository;

    @Autowired
    private EmotionReportRepository emotionReportRepository;

    @Scheduled(cron = "0 0 0 * * ?") // 每天凌晨生成报告
    public void generateDailyReport() {
        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        List<ImageData> imageDataList = imageDataRepository.findAll();

        for (ImageData imageData : imageDataList) {
            emotionAnalysisService.analyzeEmotion(imageData.getImageData()).subscribe(result -> {
                EmotionReport report = new EmotionReport();
                report.setUserId(imageData.getUserId());
                report.setReport(result);
                report.setSuggestions(generateSuggestions(result));
                report.setDate(currentDate);
                emotionReportRepository.save(report);
            });
        }
    }

    private String generateSuggestions(String analysisResult) {
        // 根据情绪分析结果生成建议的逻辑
        return "根据分析结果生成的建议";
    }

    public List<EmotionReport> getReportsByUserIdAndDate(String userId, String date) {
        return emotionReportRepository.findByUserIdAndDate(userId, date);
    }
}
