package com.example.educationalrobot1.controller;

import com.example.educationalrobot1.client.IFlyTekClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/speech")
public class SpeechSynthesisController {

    @Autowired
    private IFlyTekClient iflyTekClient;

    @PostMapping("/synthesize")
    public ResponseEntity<byte[]> synthesizeSpeech(@RequestBody String text) {
        byte[] audioData = iflyTekClient.synthesizeSpeech(text);
        return ResponseEntity.ok(audioData);
    }
}
