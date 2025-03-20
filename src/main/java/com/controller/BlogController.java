package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import com.dto.BlogDTO;
import com.exception.BlogNotFoundException;
import com.service.impl.BlogServiceImpl;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {
	@Autowired
	private BlogServiceImpl blogService;
	
	@Value("${mesg}")
	private String message;
	
	@GetMapping("/profile")
	@Tag(name="View The Active Profile")
	public ResponseEntity<String> showRole(){
		return ResponseEntity.ok(message);
	}
	
	@GetMapping
	@Tag(name="View All Blogs")
	
	public List<BlogDTO> showAllBlogs() {
		return blogService.getAllBlogs();
	}

	@GetMapping("/{blogId}")
	@Tag(name="View Blog By Id")
	public ResponseEntity<BlogDTO> getBlogById(@PathVariable("blogId") Long blogId) throws BlogNotFoundException {
		BlogDTO blog = blogService.getBlogById(blogId);
		return ResponseEntity.ok(blog);
	}

	@PostMapping
	@Tag(name="Add A Blog")
	public ResponseEntity<BlogDTO> createBlog(@Valid @RequestBody BlogDTO blogDto) {
		return new ResponseEntity<>(blogService.createBlog(blogDto), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	@Tag(name="Update A Blog")
	public ResponseEntity<BlogDTO> updateBlog(@PathVariable Long id, @Valid @RequestBody BlogDTO blogDTO) {
		return ResponseEntity.ok(blogService.updateBlog(id, blogDTO));
	}

	@DeleteMapping("/{id}")
	@Tag(name="Delete A Blog")
	public ResponseEntity<String> deleteBlog(@PathVariable Long id) {
		boolean deleteBlog = blogService.deleteBlog(id);
		System.out.println(deleteBlog+" deleted");
		return ResponseEntity.ok("Blog deleted successfully");

	}
	
	

}