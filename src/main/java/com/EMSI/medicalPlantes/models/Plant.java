package com.EMSI.medicalPlantes.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Plant {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Plant name is required")
    private String name;
    
    private String scientificName;
    private String description;

    @ElementCollection
    @CollectionTable(name = "plant_properties", joinColumns = @JoinColumn(name = "plant_id"))
    @Column(name = "property")
    private List<String> properties;

    @ElementCollection
    @CollectionTable(name = "plant_uses", joinColumns = @JoinColumn(name = "plant_id"))
    @Column(name = "use_description")
    private List<String> uses;

    @ElementCollection
    @CollectionTable(name = "plant_images", joinColumns = @JoinColumn(name = "plant_id"))
    @Column(name = "image_url")
    private List<String> images;
} 