package com.ayoub.grademanage.repository;

import com.ayoub.grademanage.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    Optional<Course> findByCode(String code);
}
