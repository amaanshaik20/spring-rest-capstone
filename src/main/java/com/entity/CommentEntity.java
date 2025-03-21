package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity // Marks this class as a JPA entity (table representation in the database)
@Table(name = "comments") // Specifies the table name in the database
public class CommentEntity {

	@Id // Marks this field as the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates unique values for the primary key
	private Long commentId;

	// Many-to-One relationship with BlogEntity
	// 'JoinColumn' specifies the foreign key column in the database linking to
	// BlogEntity
	@ManyToOne
	@JoinColumn(name = "blogId")
	private BlogEntity blogEntity;

	private String comment; // Stores the actual comment text

	// Default constructor (required by JPA)
	public CommentEntity() {

	}

	// Constructor initializing comment text and associated BlogEntity
	public CommentEntity(String comment, BlogEntity blogEntity) {
		this.comment = comment;
		this.blogEntity = blogEntity;
	}

	// Getter for commentId
	public Long getCommentId() {
		return commentId;
	}

	// Setter for commentId
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	// Getter for BlogEntity (to which this comment belongs)
	public BlogEntity getBlogEntity() {
		return blogEntity;
	}

	// Setter for BlogEntity
	public void setBlogEntity(BlogEntity blogEntity) {
		this.blogEntity = blogEntity;
	}

	// Getter for comment text
	public String getComment() {
		return comment;
	}

	// Setter for comment text
	public void setComment(String comment) {
		this.comment = comment;
	}

	// toString method for debugging/logging purposes
	@Override
	public String toString() {
		return "CommentEntity [commentId=" + commentId + ", blogEntity=" + blogEntity + ", comment=" + comment + "]";
	}

}
