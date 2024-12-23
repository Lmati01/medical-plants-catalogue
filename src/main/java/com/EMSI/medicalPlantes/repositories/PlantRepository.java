package com.EMSI.medicalPlantes.repositories;

import com.EMSI.medicalPlantes.models.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {
} 