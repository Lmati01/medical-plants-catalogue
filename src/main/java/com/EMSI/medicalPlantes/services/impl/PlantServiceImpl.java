package com.EMSI.medicalPlantes.services.impl;

import com.EMSI.medicalPlantes.models.Plant;
import com.EMSI.medicalPlantes.repositories.PlantRepository;
import com.EMSI.medicalPlantes.services.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlantServiceImpl implements PlantService {

    @Autowired
    private PlantRepository plantRepository;

    @Override
    public Plant savePlant(Plant plant) {
        return plantRepository.save(plant);
    }

    @Override
    public Plant getPlantById(Long id) {
        return plantRepository.findById(id).orElse(null);
    }

    @Override
    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    @Override
    public void deletePlant(Long id) {
        plantRepository.deleteById(id);
    }
} 