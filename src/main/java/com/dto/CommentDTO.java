package com.dto;

import jakarta.validation.constraints.NotBlank;

public class CommentDTO {
	private Integer commentId;
	private int blogId;
	@NotBlank(message = "Comment cannot be blank")
	private String comment;
	
	public CommentDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public CommentDTO(int blogId, String comment) {
		super();
		this.blogId = blogId;
		this.comment = comment;
	}
	
	

	public CommentDTO(Integer commentId, int blogId, String comment) {
		super();
		this.commentId = commentId;
		this.comment = comment;
	}


	


	public Integer getCommentId() {
		return commentId;
	}


	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}


	public int getBlogId() {
		return blogId;
	}


	public void setBlogId(int blogId) {
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
