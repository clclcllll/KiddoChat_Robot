package com.example.educationalrobot1.controller;

import com.example.educationalrobot1.client.IFlyTekClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/speech")
public class SpeechRecognitionController {

    @Autowired
    private IFlyTekClient iflyTekClient;

    @PostMapping("/recognize")
    public ResponseEntity<String> recognizeSpeech(@RequestBody byte[] audioData) {
        String result = iflyTekClient.recognizeSpeech(audioData);
        return ResponseEntity.ok(result);
    }
}
