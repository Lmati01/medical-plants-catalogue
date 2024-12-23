package com.EMSI.medicalPlantes.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PlantDTO {
    private Long id;
    
    @NotBlank(message = "Plant name is required")
    private String name;
    
    private String scientificName;
    private String description;
    private String medicalUses;
}