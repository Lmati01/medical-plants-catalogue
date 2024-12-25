package com.EMSI.medicalPlantes.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Welcome to Medical Plants API");
        response.put("endpoints", new String[]{
            "/plants - Get all plants",
            "/api/auth/login - Login",
            "/api/auth/signup - Register",
            "/plants/{id} - Get plant by ID"
        });
        return response;
    }
} 