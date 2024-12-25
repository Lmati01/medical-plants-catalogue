package com.EMSI.medicalPlantes.services;

import com.EMSI.medicalPlantes.models.Article;
import com.EMSI.medicalPlantes.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    public Article getArticleById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));
    }

    public List<Article> getArticlesByPlantId(Long plantId) {
        return articleRepository.findByPlantId(plantId);
    }

    public List<Article> getArticlesByAuthorId(Long authorId) {
        return articleRepository.findByAuthorId(authorId);
    }

    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
} 