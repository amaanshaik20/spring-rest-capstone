package com.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class BlogDTO {

	private Long blogId;

	// Ensures the title is not blank and has a length between 3 and 100 characters
	@NotBlank(message = "Title cannot be blank")
	@Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
	private String blogTitle;

	// Ensures the content is not blank and has a length between 3 and 200
	// characters
	@NotBlank(message = "Content cannot be blank")
	@Size(min = 3, max = 200, message = "Content must be between 3 and 200 characters")
	private String blogContent;

	// Default constructor (needed for frameworks like Spring or Hibernate)
	public BlogDTO() {
}

	// Constructor initializing title and content
	public BlogDTO(String blogTitle, String blogContent) {
		super(); // Calls the superclass constructor (not necessary here)
		this.blogTitle = blogTitle;
		this.blogContent = blogContent;
	}

	// Constructor initializing all fields including ID
	public BlogDTO(Long blogId, String blogTitle, String blogContent) {
		super(); // Calls the superclass constructor
		this.blogId = blogId;
		this.blogTitle = blogTitle;
		this.blogContent = blogContent;
	}

	// Getter for blogId
	public Long getBlogId() {
		return blogId;
	}

	// Setter for blogId
	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

	// Getter for blogTitle
	public String getBlogTitle() {
		return blogTitle;
	}

	// Setter for blogTitle
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	// Getter for blogContent
	public String getBlogContent() {
		return blogContent;
	}

	// Setter for blogContent
	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	// toString method for debugging/logging purposes
	@Override
	public String toString() {
		return "BlogDTO [blogId=" + blogId + ", blogTitle=" + blogTitle + ", blogContent=" + blogContent + "]";
	}
}
