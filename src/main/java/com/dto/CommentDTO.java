package com.dto;

public class CommentDTO {
	
	private Integer commentId;
	private BlogDTO blogDTO;
	private String comment;
	
	public CommentDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public CommentDTO(BlogDTO blogDTO, String comment) {
		super();
		this.blogDTO = blogDTO;
		this.comment = comment;
	}
	
	

	public CommentDTO(Integer commentId, BlogDTO blogDTO, String comment) {
		super();
		this.commentId = commentId;
		this.blogDTO = blogDTO;
		this.comment = comment;
	}


	


	public Integer getCommentId() {
		return commentId;
	}


	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}


	public BlogDTO getBlogDTO() {
		return blogDTO;
	}


	public void setBlogDTO(BlogDTO blogDTO) {
		this.blogDTO = blogDTO;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	@Override
	public String toString() {
		return "CommentDTO [commentId=" + commentId + ", blogDTO=" + blogDTO + ", comment=" + comment + "]";
	}
	
	
	
	
}
