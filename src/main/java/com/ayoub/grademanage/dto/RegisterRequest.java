package com.ayoub.grademanage.dto;

import com.ayoub.grademanage.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String username;
    private String password;
    private Role role;
}

// Separate files would be better but I'll group them for now if needed, 
// actually I'll create separate ones as per standard.
