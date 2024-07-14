package com.example.app.controller;

import com.example.app.entity.Baby;
import com.example.app.service.BabyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/baby")
public class BabyController {

    @Autowired
    private BabyService babyService;

    @PostMapping("/add")
    public Baby addBaby(@RequestBody Baby baby) {
        return babyService.addBaby(baby);
    }

    @PostMapping("/update")
    public Baby updateBaby(@RequestBody Baby baby) {
        return babyService.updateBaby(baby);
    }

    @PostMapping("/delete")
    public void deleteBaby(@RequestParam Long babyId) {
        babyService.deleteBaby(babyId);
    }

    @GetMapping("/list")
    public List<Baby> listBabies(@RequestParam Long userId) {
        return babyService.listBabies(userId);
    }
}
