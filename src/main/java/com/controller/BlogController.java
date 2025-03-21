package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.BlogDTO;
import com.exception.BlogNotFoundException;
import com.service.BlogService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController // Marks this class as a REST controller, allowing it to handle HTTP requests
@RequestMapping("/api/blogs") // Base URL for all endpoints in this controller
@Validated // Enables validation for request bodies and path variables
public class BlogController {

	private BlogService blogService;

	// Constructor-based dependency injection for BlogService
	public BlogController(BlogService blogService) {
		this.blogService = blogService;
	}

	@Value("${mesg}")
	private String message;

	// Endpoint to view the active profile
	@GetMapping("/profile")
	@Tag(name = "View The Active Profile")
	public ResponseEntity<String> showRole() {
		return ResponseEntity.ok(message);
	}

	// Endpoint to retrieve all blogs
	@GetMapping
	@Tag(name = "View All Blogs")
	public List<BlogDTO> showAllBlogs() {
		return blogService.getAllBlogs();
	}

	// Endpoint to retrieve a blog by its ID
	@GetMapping("/{blogId}")
	@Tag(name = "View Blog By Id")
	public ResponseEntity<BlogDTO> getBlogById(@PathVariable("blogId") Long blogId) throws BlogNotFoundException {
		BlogDTO blog = blogService.getBlogById(blogId);
		return ResponseEntity.ok(blog);
	}

	// Endpoint to create a new blog
	@PostMapping
	@Tag(name = "Add A Blog")
	public ResponseEntity<BlogDTO> createBlog(@Valid @RequestBody BlogDTO blogDto) {
		return new ResponseEntity<>(blogService.createBlog(blogDto), HttpStatus.CREATED);
	}

	// Endpoint to update an existing blog by ID
	@PutMapping("/{id}")
	@Tag(name = "Update A Blog")
	public ResponseEntity<BlogDTO> updateBlog(@PathVariable Long id, @Valid @RequestBody BlogDTO blogDTO) {
		return ResponseEntity.ok(blogService.updateBlog(id, blogDTO));
	}

	// Endpoint to delete a blog by ID
	@DeleteMapping("/{id}")
	@Tag(name = "Delete A Blog")
	public ResponseEntity<String> deleteBlog(@PathVariable Long id) {
		boolean deleteBlog = blogService.deleteBlog(id);
		System.out.println(deleteBlog + " deleted"); // Logs the deletion status
		return ResponseEntity.ok("Blog deleted successfully");
	}

}
