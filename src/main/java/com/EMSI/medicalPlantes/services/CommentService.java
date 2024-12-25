package com.EMSI.medicalPlantes.services;

import com.EMSI.medicalPlantes.models.Comment;
import com.EMSI.medicalPlantes.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByPlantId(Long plantId) {
        return commentRepository.findByPlantId(plantId);
    }

    public List<Comment> getCommentsByUserId(Long userId) {
        return commentRepository.findByUserId(userId);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
} 