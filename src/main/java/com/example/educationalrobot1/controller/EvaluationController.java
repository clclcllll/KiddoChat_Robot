package com.example.educationalrobot1.controller;

import com.example.educationalrobot1.service.EvaluationService;
import com.example.educationalrobot1.dto.EvaluationRequest;
import com.example.educationalrobot1.dto.EvaluationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/evaluation")
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;

    @PostMapping("/evaluate")
    public ResponseEntity<EvaluationResult> evaluate(@RequestBody EvaluationRequest request) {
        EvaluationResult result = evaluationService.evaluate(request);
        return ResponseEntity.ok(result);
    }
}
