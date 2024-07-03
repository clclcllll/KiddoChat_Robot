package com.example.educationalrobot1.service;

import com.example.educationalrobot1.dto.EvaluationRequest;
import com.example.educationalrobot1.dto.EvaluationResult;
import com.example.educationalrobot1.repository.EvaluationResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluationService {

    @Autowired
    private EvaluationResultRepository evaluationResultRepository;

    public EvaluationResult evaluate(EvaluationRequest request) {
        // 实现智能测评逻辑
        EvaluationResult result = new EvaluationResult();
        result.setUserResponse(request.getUserResponse());
        result.setEvaluationScore("A+");

        // 保存评估结果
        return evaluationResultRepository.save(result);
    }
}
