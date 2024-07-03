package com.example.educationalrobot1.repository;

import com.example.educationalrobot1.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationResultRepository extends JpaRepository<Evaluation, Long> {
}
