package com.dto;

import jakarta.validation.constraints.NotBlank;

public class CommentDTO {
	private Long commentId;
	private Long blogId;
	@NotBlank(message = "Comment cannot be blank")
	private String comment;
	
	public CommentDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public CommentDTO(Long blogId, String comment) {
		super();
		this.blogId = blogId;
		this.comment = comment;
	}
	
	

	public CommentDTO(Long commentId, Long blogId, String comment) {
		super();
		this.commentId = commentId;
		this.comment = comment;
	}


	


	public Long getCommentId() {
		return commentId;
	}


	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}


	public Long getBlogId() {
		return blogId;
	}


	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}


	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "CommentDTO [commentId=" + commentId + ", blogId=" + blogId + ", comment=" + comment + "]";
	}
	
}
