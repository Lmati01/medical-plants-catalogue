package com.EMSI.medicalPlantes.repositories;

import com.EMSI.medicalPlantes.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPlantId(Long plantId);
    List<Comment> findByUserId(Long userId);
} 