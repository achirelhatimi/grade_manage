package com.ayoub.grademanage.service;

import com.ayoub.grademanage.model.Course;
import com.ayoub.grademanage.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository repository;

    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    public Course getCourseById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public Course createCourse(Course course) {
        return repository.save(course);
    }

    public Course updateCourse(Integer id, Course courseDetails) {
        Course course = getCourseById(id);
        course.setName(courseDetails.getName());
        course.setCode(courseDetails.getCode());
        course.setCredits(courseDetails.getCredits());
        return repository.save(course);
    }

    public void deleteCourse(Integer id) {
        repository.deleteById(id);
    }
}
