package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.BlogEntity;

import jakarta.transaction.Transactional;

@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Integer> {
	
	@Modifying
	@Transactional
	@Query("update BlogEntity b set b.blogTitle=:title where b.blogId=:id")
	public void updateBlogTitle(@Param("title") String title, @Param("id") int id);
}
