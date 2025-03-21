package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.CommentDTO;
import com.entity.BlogEntity;
import com.entity.CommentEntity;
import com.exception.BlogNotFoundException;
import com.exception.CommentNotFoundException;
import com.exception.CustomException;
import com.repository.BlogRepository;
import com.repository.CommentRepository;
import com.service.CommentService;

import jakarta.validation.Valid;

@Service
public class CommentServiceImpl implements CommentService {
	// Dependencies for interacting with repositories
	private BlogRepository blogRepository;
	private CommentRepository commentRepo;

	// Constructor-based dependency injection
	public CommentServiceImpl(BlogRepository blogRepository, CommentRepository commentRepo) {
		this.blogRepository = blogRepository;
		this.commentRepo = commentRepo;
	}

	// Converts CommentEntity to CommentDTO for returning data in a clean format
	private CommentDTO convertToCommentDTO(CommentEntity commentEntity) {
		return new CommentDTO(commentEntity.getCommentId(), commentEntity.getBlogEntity().getBlogId(),
				commentEntity.getComment());
	}

	// Creates a new comment for a blog post and saves it in the repository
	@Override
	public CommentDTO addComment(CommentDTO commentDTO) {
		Long id = commentDTO.getBlogId();
		// Fetch the blog, throw exception if not found
		BlogEntity blog = blogRepository.findById(id)
				.orElseThrow(() -> new BlogNotFoundException("Blog not found with ID: " + id));

		// Create a new CommentEntity and associate it with the blog
		CommentEntity commentEntity = new CommentEntity();
		commentEntity.setComment(commentDTO.getComment());
		commentEntity.setBlogEntity(blog);

		// Save the comment and return DTO
		commentEntity = commentRepo.save(commentEntity);
		return convertToCommentDTO(commentEntity);
	}

	// Retrieves all comments for a given blog ID
	@Override
	public List<String> getCommentsOf(Long id) {
		// Validate that ID is not negative
		if (id < 0) {
			throw new CustomException("Comment ID cannot be negative");
		}

		// Fetch the blog, throw exception if not found
		BlogEntity blog = blogRepository.findById(id)
				.orElseThrow(() -> new BlogNotFoundException("Blog not found with ID: " + id));

		// Extract comments from blog entity and return as a list of strings
		List<String> commentsList = new ArrayList<>();
		for (CommentEntity comment : blog.getCommentsList()) {
			commentsList.add(comment.getComment());
		}
		return commentsList;
	}

	// Deletes a comment given its ID
	@Override
	public boolean deleteComment(Long commentid) {
		// Validate that ID is not negative
		if (commentid < 0) {
			throw new CustomException("Comment ID cannot be negative");
		}

		// Fetch the comment, throw exception if not found
		CommentEntity comment = commentRepo.findById(commentid)
				.orElseThrow(() -> new CommentNotFoundException("Comment not found with ID: " + commentid));

		// Delete the comment from repository
		System.out.println("Deleting Comment: " + comment);
		commentRepo.delete(comment);
		System.out.println("Comment deleted successfully!");
		return true;
	}

	// Updates an existing comment
	@Override
	public CommentDTO updateBlog(Long commentid, @Valid CommentDTO commentDTO) {
		// Validate that ID is not negative
		if (commentid < 0) {
			throw new CustomException("Comment ID cannot be negative");
		}

		// Fetch the comment, throw exception if not found
		CommentEntity comment = commentRepo.findById(commentid)
				.orElseThrow(() -> new CommentNotFoundException("Comment not found with ID: " + commentid));

		// Update the comment content
		comment.setComment(commentDTO.getComment());
		CommentEntity savedBlog = commentRepo.save(comment);

		// Convert entity to DTO and return
		return convertToCommentDTO(savedBlog);
	}
}