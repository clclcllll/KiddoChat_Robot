package com.example.educationalrobot1.service;

import com.example.educationalrobot1.client.IFlyTekClient;
import com.example.educationalrobot1.dto.NaturalLanguageProcessingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NaturalLanguageProcessingService {

    @Autowired
    private IFlyTekClient iflyTekClient;

    public String processText(NaturalLanguageProcessingRequest request) {
        return iflyTekClient.processText(request.getText());
    }
}
