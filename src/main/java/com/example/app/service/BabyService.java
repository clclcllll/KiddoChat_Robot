package com.example.app.service;

import com.example.app.entity.Baby;
import com.example.app.repository.BabyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BabyService {

    @Autowired
    private BabyRepository babyRepository;

    public Baby addBaby(Baby baby) {
        return babyRepository.save(baby);
    }

    public Baby updateBaby(Baby baby) {
        return babyRepository.save(baby);
    }

    public void deleteBaby(Long babyId) {
        babyRepository.deleteById(babyId);
    }

    public List<Baby> listBabies(Long userId) {
        return babyRepository.findByUserId(userId);
    }
}
