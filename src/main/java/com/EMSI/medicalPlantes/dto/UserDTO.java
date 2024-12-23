package com.EMSI.medicalPlantes.dto;

import com.EMSI.medicalPlantes.models.Role;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String fullName;
    private Role role;
} 