package com.example.educationalrobot1.controller;

import com.example.educationalrobot1.service.IFlyTekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/iflytek")
public class IFlyTekController {

    @Autowired
    private IFlyTekService iflyTekService;

    @PostMapping("/spark")
    public ResponseEntity<String> getSparkResponse(@RequestBody Map<String, String> request) {
        String inputText = request.get("text");
        String response = iflyTekService.callSparkModel(inputText);
        return ResponseEntity.ok(response);
    }
}
