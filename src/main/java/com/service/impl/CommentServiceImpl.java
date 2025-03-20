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
import com.repository.BlogRepository;
import com.repository.CommentRepository;
import com.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	private BlogRepository blogRepository;

	private CommentRepository commentRepo;

	@Autowired
	public CommentServiceImpl(BlogRepository blogRepository, CommentRepository commentRepo) {
		this.blogRepository = blogRepository;
		this.commentRepo = commentRepo;
	}

	// Converts CommentEntity to CommentDTO
	private CommentDTO convertToCommentDTO(CommentEntity commentEntity) {
		return new CommentDTO(commentEntity.getCommentId(), commentEntity.getBlogEntity().getBlogId(),
				commentEntity.getComment());
	}

	// Creates a new Comment to the blog and saves it to the repository
	public CommentDTO addComment(CommentDTO commentDTO) {
		int id = commentDTO.getBlogId();
		BlogEntity blog = blogRepository.findById(id)
				.orElseThrow(() -> new BlogNotFoundException("Blog not found with ID: " + id));

		CommentEntity commentEntity = new CommentEntity();
		commentEntity.setComment(commentDTO.getComment());
		commentEntity.setBlogEntity(blog);
		commentEntity = commentRepo.save(commentEntity);
		return convertToCommentDTO(commentEntity);
	}

	// Retrieves all comments for a given blog ID
	public List<String> getCommentsOf(int id) {
		BlogEntity blog = blogRepository.findById(id)
				.orElseThrow(() -> new BlogNotFoundException("Blog not found with ID: " + id));
		List<String> commentsList = new ArrayList<>();
		for (CommentEntity comment : blog.getCommentsList()) {
			commentsList.add(comment.getComment());
		}
		return commentsList;
	}

//	public boolean deleteComment(int commentid) {
//		try {
//			CommentEntity comment = commentRepo.findById(commentid)
//					.orElseThrow(() -> new CommentNotFoundException("Comment not found with ID: " + commentid));
//
//			commentRepo.deleteById(comment.getCommentId());
//			System.out.println("Comment deleted successfully!");
//			return true;
//		} catch (CommentNotFoundException e) {
//			return false;
//		}
//	}

	// deletes the comment taking commentid as parameter
	public boolean deleteComment(int commentid) {
		CommentEntity comment = commentRepo.findById(commentid)
				.orElseThrow(() -> new CommentNotFoundException("Comment not found with ID: " + commentid));
		System.out.println("Deleting Comment: " + comment);
		commentRepo.delete(comment);
		System.out.println("Comment deleted successfully!");
		return true;

	}

}
