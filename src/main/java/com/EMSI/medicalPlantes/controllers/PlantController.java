package com.EMSI.medicalPlantes.controllers;

import com.EMSI.medicalPlantes.models.Plant;
import com.EMSI.medicalPlantes.services.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plants")
public class PlantController {

    @Autowired
    private PlantService plantService;

    @PostMapping
    public Plant createPlant(@RequestBody Plant plant) {
        return plantService.savePlant(plant);
    }

    @GetMapping("/{id}")
    public Plant getPlant(@PathVariable Long id) {
        return plantService.getPlantById(id);
    }

    @GetMapping
    public List<Plant> getAllPlants() {
        return plantService.getAllPlants();
    }

    @PutMapping("/{id}")
    public Plant updatePlant(@PathVariable Long id, @RequestBody Plant plant) {
        plant.setId(id);
        return plantService.savePlant(plant);
    }

    @DeleteMapping("/{id}")
    public void deletePlant(@PathVariable Long id) {
        plantService.deletePlant(id);
    }
} 