package com.example.educationalrobot1.service;

import com.example.educationalrobot1.client.IFlyTekClient;
import com.example.educationalrobot1.dto.SpeechRecognitionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpeechRecognitionService {

    @Autowired
    private IFlyTekClient iflyTekClient;

    public String recognizeSpeech(SpeechRecognitionRequest request) {
        return iflyTekClient.recognizeSpeech(request.getAudioData());
    }
}
