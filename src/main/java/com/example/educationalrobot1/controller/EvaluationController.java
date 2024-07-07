package com.example.educationalrobot1.controller;

import com.example.educationalrobot1.dto.EvaluationRequest;
import com.example.educationalrobot1.entity.Evaluation;
import com.example.educationalrobot1.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/evaluation")
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;

    @PostMapping("/evaluate")
    public Evaluation evaluate(@RequestBody EvaluationRequest request) {
        return evaluationService.evaluate(request);
    }
}
