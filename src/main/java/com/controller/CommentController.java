package com.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dto.BlogDTO;
import com.dto.CommentDTO;
import com.service.CommentService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

@RestController // Marks this class as a REST controller handling HTTP requests
@RequestMapping("/api/blogs") // Base URL for all endpoints related to comments
public class CommentController {

	private CommentService commentService;

	// Constructor-based dependency injection for CommentService
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	// Endpoint to add a new comment
	@PostMapping("/comment")
	@Tag(name = "Add A Comment")
	public ResponseEntity<CommentDTO> createComment(@Valid @RequestBody CommentDTO commentDTO) {
		return new ResponseEntity<>(commentService.addComment(commentDTO), HttpStatus.CREATED);
	}

	// Endpoint to retrieve all comments for a given blog ID
	@GetMapping("/{blogid}/comments")
	@Tag(name = "View All Comments of blog id")
	public ResponseEntity<List<String>> showAllComments(@PathVariable Long blogid) {
		List<String> comments = commentService.getCommentsOf(blogid);
		return ResponseEntity.ok(comments);
	}

	// Endpoint to delete a comment by its ID
	@DeleteMapping("/comment/{commentid}")
	@Tag(name = "Delete A Comment")
	public ResponseEntity<String> deleteComment(@PathVariable Long commentid) {
		boolean isDeleted = commentService.deleteComment(commentid);
		if (isDeleted) {
			return ResponseEntity.ok("Comment deleted successfully");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comment not found with ID: " + commentid);
	}

	// Endpoint to update a comment by its ID
	@PutMapping("/comment/{commentid}")
	@Tag(name = "Update A Comment")
	public ResponseEntity<CommentDTO> updateBlog(@PathVariable Long commentid,
			@Valid @RequestBody CommentDTO commentDTO) {
		return ResponseEntity.ok(commentService.updateBlog(commentid, commentDTO));
	}

	@GetMapping("/comments")
	@Tag(name = "View All Comments of blog id by Request Param")
	public ResponseEntity<List<String>> showComments(@RequestParam("blogId") Long blogId) {
		 List<String> comments = commentService.getCommentsOf(blogId);
		 return ResponseEntity.ok(comments);
	}
}
