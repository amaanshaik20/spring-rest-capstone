package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.entity.CommentEntity;

@Repository // Marks this interface as a repository component for database operations
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    // JpaRepository provides built-in CRUD operations for CommentEntity
}
