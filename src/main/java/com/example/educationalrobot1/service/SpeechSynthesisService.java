package com.example.educationalrobot1.service;

import com.example.educationalrobot1.client.IFlyTekClient;
import com.example.educationalrobot1.dto.SpeechSynthesisRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpeechSynthesisService {

    @Autowired
    private IFlyTekClient iflyTekClient;

    public byte[] synthesizeSpeech(SpeechSynthesisRequest request) {
        return iflyTekClient.synthesizeSpeech(request.getText());
    }
}
