package com.example.educationalrobot1.controller;

import com.example.educationalrobot1.client.IFlyTekClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nlp")
public class NaturalLanguageProcessingController {

    @Autowired
    private IFlyTekClient iflyTekClient;

    @PostMapping("/process")
    public ResponseEntity<String> processText(@RequestBody String text) {
        String result = iflyTekClient.processText(text);
        return ResponseEntity.ok(result);
    }
}
