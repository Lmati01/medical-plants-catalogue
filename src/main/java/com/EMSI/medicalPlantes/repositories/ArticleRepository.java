package com.EMSI.medicalPlantes.repositories;

import com.EMSI.medicalPlantes.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByPlantId(Long plantId);
    List<Article> findByAuthorId(Long authorId);
} 