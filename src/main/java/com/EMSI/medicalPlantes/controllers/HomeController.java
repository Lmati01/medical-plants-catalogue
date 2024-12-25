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
        
        Map<String, String[]> endpoints = new HashMap<>();
        
        // Authentication endpoints
        endpoints.put("Authentication", new String[]{
            "POST /api/auth/signup - Register new user",
            "POST /api/auth/login - Login user"
        });
        
        // Plant endpoints
        endpoints.put("Plants", new String[]{
            "GET /plants - Get all plants",
            "GET /plants/{id} - Get plant by ID",
            "POST /plants - Create new plant",
            "PUT /plants/{id} - Update plant",
            "DELETE /plants/{id} - Delete plant"
        });
        
        // Article endpoints
        endpoints.put("Articles", new String[]{
            "POST /api/articles/add - Create new article",
            "GET /api/articles/{id} - Get article by ID",
            "GET /api/articles/plant/{plantId} - Get articles by plant",
            "GET /api/articles/author/{authorId} - Get articles by author",
            "PUT /api/articles/update/{id} - Update article",
            "DELETE /api/articles/delete/{id} - Delete article"
        });
        
        // Comment endpoints
        endpoints.put("Comments", new String[]{
            "POST /api/comments/add - Add new comment",
            "GET /api/comments/plant/{plantId} - Get comments by plant",
            "GET /api/comments/user/{userId} - Get comments by user",
            "DELETE /api/comments/delete/{id} - Delete comment"
        });

        response.put("endpoints", endpoints);
        return response;
    }
} 