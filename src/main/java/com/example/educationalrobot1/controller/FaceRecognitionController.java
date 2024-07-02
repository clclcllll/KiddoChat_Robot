package com.example.educationalrobot1.controller;

import com.example.educationalrobot1.client.IFlyTekClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/face")
public class FaceRecognitionController {

    @Autowired
    private IFlyTekClient iflyTekClient;

    @PostMapping("/recognize")
    public ResponseEntity<String> recognizeFace(@RequestBody byte[] imageData) {
        String result = iflyTekClient.recognizeFace(imageData);
        return ResponseEntity.ok(result);
    }
}
