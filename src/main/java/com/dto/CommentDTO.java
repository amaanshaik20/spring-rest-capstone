package com.dto;

import com.entity.BlogEntity;

public class CommentDTO {
	
	private Integer commentId;
	private BlogEntity blogEntity;
	private String comment;
	
	public CommentDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public CommentDTO(BlogEntity blogEntity, String comment) {
		super();
		this.blogEntity = blogEntity;
		this.comment = comment;
	}


	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public BlogEntity getBlogEntity() {
		return blogEntity;
	}
	public void setBlogEntity(BlogEntity blogEntity) {
		this.blogEntity = blogEntity;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}


	@Override
	public String toString() {
		return "CommentDTO [commentId=" + commentId + ", blogEntity=" + blogEntity + ", comment=" + comment + "]";
	}
	
	
	
	
}
