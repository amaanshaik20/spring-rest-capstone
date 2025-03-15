package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.BlogDTO;
import com.exception.BlogNotFoundException;
import com.service.BlogService;

@RestController
@RequestMapping("/api")
public class BlogController {
	@Autowired
	private BlogService blogService;

	@GetMapping("/blogs")
	public List<BlogDTO> showAllBlogs() {
		return blogService.getAllBlogs();
	}

	@GetMapping("/blogs/{blogId}")
	public ResponseEntity<BlogDTO> getBlogById(@PathVariable("blogId") int blogId) throws BlogNotFoundException {
		BlogDTO blog = blogService.getBlogById(blogId);
		return ResponseEntity.ok(blog);
	}
}