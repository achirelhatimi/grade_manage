package com.ayoub.grademanage.repository;

import com.ayoub.grademanage.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Integer> {
    List<Grade> findByStudentId(Integer studentId);
    List<Grade> findByCourseId(Integer courseId);
}
