package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="comments")
public class CommentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer commentId;
	@ManyToOne
	@JoinColumn(name = "blogId")
	private BlogEntity blogEntity;
	
	private String comment;
	
	public CommentEntity() {
		
	}
	public CommentEntity(String comment, BlogEntity blogEntity){
		this.comment=comment;
		this.blogEntity=blogEntity;
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
		return "CommentEntity [commentId=" + commentId + ", blogEntity=" + blogEntity + ", comment=" + comment + "]";
	}
	
	
	
	
}
