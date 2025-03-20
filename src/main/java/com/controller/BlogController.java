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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {
	@Autowired
	private BlogServiceImpl blogService;
	
	@Value("${mesg}")
	private String message;
	
	@GetMapping("/profile")
	public ResponseEntity<String> showRole(){
		return ResponseEntity.ok(message);
	}
	
	@GetMapping
	public List<BlogDTO> showAllBlogs() {
		return blogService.getAllBlogs();
	}

	@GetMapping("/{blogId}")
	public ResponseEntity<BlogDTO> getBlogById(@PathVariable("blogId") int blogId) throws BlogNotFoundException {
		BlogDTO blog = blogService.getBlogById(blogId);
		return ResponseEntity.ok(blog);
	}

	@PostMapping
	public ResponseEntity<BlogDTO> createBlog(@Valid @RequestBody BlogDTO blogDto) {
		return new ResponseEntity<>(blogService.createBlog(blogDto), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<BlogDTO> updateBlog(@PathVariable int id, @Valid @RequestBody BlogDTO blogDTO) {
		return ResponseEntity.ok(blogService.updateBlog(id, blogDTO));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBlog(@PathVariable int id) {
		boolean deleteBlog = blogService.deleteBlog(id);
		System.out.println(deleteBlog+" deleted");
		return ResponseEntity.ok("Blog deleted successfully");

	}
	
	

}