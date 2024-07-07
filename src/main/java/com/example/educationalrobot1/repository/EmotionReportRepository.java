package com.example.educationalrobot1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.educationalrobot1.entity.EmotionReport;
import java.util.List;  // 确保导入了java.util.List

@Repository
public interface EmotionReportRepository extends JpaRepository<EmotionReport, Long> {
    List<EmotionReport> findByUserIdAndDate(String userId, String date);
}
