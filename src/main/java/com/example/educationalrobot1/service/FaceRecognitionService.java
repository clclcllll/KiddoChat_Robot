package com.example.educationalrobot1.service;

import com.example.educationalrobot1.client.IFlyTekClient;
import com.example.educationalrobot1.dto.FaceRecognitionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FaceRecognitionService {

    @Autowired
    private IFlyTekClient iflyTekClient;

    public String recognizeFace(FaceRecognitionRequest request) {
        return iflyTekClient.recognizeFace(request.getImageData());
    }
}
