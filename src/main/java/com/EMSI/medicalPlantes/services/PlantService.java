package com.EMSI.medicalPlantes.services;

import com.EMSI.medicalPlantes.models.Plant;
import com.EMSI.medicalPlantes.repositories.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlantService {

    @Autowired
    private PlantRepository plantRepository;

    public Plant savePlant(Plant plant) {
        return plantRepository.save(plant);
    }

    public Plant getPlantById(Long id) {
        return plantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plant not found"));
    }

    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    public void deletePlant(Long id) {
        plantRepository.deleteById(id);
    }
} 