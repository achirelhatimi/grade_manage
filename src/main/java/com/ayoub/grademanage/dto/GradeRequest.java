package com.ayoub.grademanage.dto;

import lombok.Data;

@Data
public class GradeRequest {
    private Integer studentId;
    private Integer courseId;
    private Double score;
    private String feedback;
}
