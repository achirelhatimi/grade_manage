package com.ayoub.grademanage.service;

import com.ayoub.grademanage.dto.GradeRequest;
import com.ayoub.grademanage.model.Course;
import com.ayoub.grademanage.model.Grade;
import com.ayoub.grademanage.model.Student;
import com.ayoub.grademanage.repository.CourseRepository;
import com.ayoub.grademanage.repository.GradeRepository;
import com.ayoub.grademanage.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeService {

    private final GradeRepository repository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<Grade> getAllGrades() {
        return repository.findAll();
    }

    public List<Grade> getGradesByStudent(Integer studentId) {
        return repository.findByStudentId(studentId);
    }

    public Grade createGrade(GradeRequest request) {
        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Grade grade = Grade.builder()
                .student(student)
                .course(course)
                .score(request.getScore())
                .feedback(request.getFeedback())
                .build();
        
        return repository.save(grade);
    }

    public Grade updateGrade(Integer id, GradeRequest request) {
        Grade grade = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grade not found"));
        
        grade.setScore(request.getScore());
        grade.setFeedback(request.getFeedback());
        
        return repository.save(grade);
    }

    public void deleteGrade(Integer id) {
        repository.deleteById(id);
    }
}
