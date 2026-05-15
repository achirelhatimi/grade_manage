package com.ayoub.grademanage.service;

import com.ayoub.grademanage.model.Student;
import com.ayoub.grademanage.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student createStudent(Student student) {
        return repository.save(student);
    }

    public Student updateStudent(Integer id, Student studentDetails) {
        Student student = getStudentById(id);
        student.setFirstName(studentDetails.getFirstName());
        student.setLastName(studentDetails.getLastName());
        student.setEmail(studentDetails.getEmail());
        return repository.save(student);
    }

    public void deleteStudent(Integer id) {
        repository.deleteById(id);
    }
}
