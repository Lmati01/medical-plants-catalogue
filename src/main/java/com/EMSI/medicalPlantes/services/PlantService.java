package com.EMSI.medicalPlantes.services;

import com.EMSI.medicalPlantes.models.Plant;
import java.util.List;

public interface PlantService {
    Plant savePlant(Plant plant);
    Plant getPlantById(Long id);
    List<Plant> getAllPlants();
    void deletePlant(Long id);
} 