package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.CommentDTO;
import com.service.impl.CommentServiceImpl;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/blogs")
public class CommentController {
	private CommentServiceImpl commentService;
	
	@Autowired
	public CommentController(CommentServiceImpl commentService) {
		this.commentService=commentService;
	}
	@PostMapping("/comment")
	@Tag(name="Add A Comment")
	public ResponseEntity<CommentDTO> createComment(@Valid @RequestBody CommentDTO commentDTO) {
		return new ResponseEntity<>(commentService.addComment(commentDTO), HttpStatus.CREATED);
	}

	@GetMapping("/{blogid}/comments")
	@Tag(name="View All Comments of blog id")
	public ResponseEntity<List<String>> showAllComments(@PathVariable Long blogid) {
		List<String> comments = commentService.getCommentsOf(blogid);
		return ResponseEntity.ok(comments);
	}
	
	@DeleteMapping("/comment/{commentid}")
	@Tag(name="Delete A Comment")
	public ResponseEntity<String> deleteComment(@PathVariable Long commentid) {
	    boolean isDeleted = commentService.deleteComment(commentid); 
	    if (isDeleted) {
	        return ResponseEntity.ok("Comment deleted successfully");
	    }
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comment not found with ID: " + commentid);
	}
	
	
	@PutMapping("/comment/{commentid}")
	@Tag(name="Update A Comment")
	public ResponseEntity<CommentDTO> updateBlog(@PathVariable Long commentid, @Valid @RequestBody CommentDTO commentDTO) {
		return ResponseEntity.ok(commentService.updateBlog(commentid, commentDTO));
	}

}













