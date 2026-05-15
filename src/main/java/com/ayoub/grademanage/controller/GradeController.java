package com.ayoub.grademanage.controller;

import com.ayoub.grademanage.dto.GradeRequest;
import com.ayoub.grademanage.model.Grade;
import com.ayoub.grademanage.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/grades")
@RequiredArgsConstructor
public class GradeController {

    private final GradeService service;

    @GetMapping
    public List<Grade> getAllGrades() {
        return service.getAllGrades();
    }

    @GetMapping("/student/{studentId}")
    public List<Grade> getGradesByStudent(@PathVariable Integer studentId) {
        return service.getGradesByStudent(studentId);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public ResponseEntity<Grade> createGrade(@RequestBody GradeRequest request) {
        return ResponseEntity.ok(service.createGrade(request));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public ResponseEntity<Grade> updateGrade(@PathVariable Integer id, @RequestBody GradeRequest request) {
        return ResponseEntity.ok(service.updateGrade(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteGrade(@PathVariable Integer id) {
        service.deleteGrade(id);
        return ResponseEntity.noContent().build();
    }
}
