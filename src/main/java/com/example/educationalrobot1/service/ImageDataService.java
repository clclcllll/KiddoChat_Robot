package com.example.educationalrobot1.service;

import com.example.educationalrobot1.entity.ImageData;
import com.example.educationalrobot1.repository.ImageDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageDataService {

    @Autowired
    private ImageDataRepository imageDataRepository;

    public List<ImageData> getAllImageData() {
        return imageDataRepository.findAll();
    }

    public ImageData saveImageData(ImageData imageData) {
        return imageDataRepository.save(imageData);
    }
}
