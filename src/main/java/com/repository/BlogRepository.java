package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.entity.BlogEntity;

@Repository // Marks this interface as a Spring Data repository
public interface BlogRepository extends JpaRepository<BlogEntity, Long> {
	// JpaRepository provides CRUD operations for BlogEntity without needing implementation
}
