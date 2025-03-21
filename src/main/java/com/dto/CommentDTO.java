package com.dto;

import jakarta.validation.constraints.NotBlank;

public class CommentDTO {
    
    private Long commentId;
    
    private Long blogId;
    
    // Ensures the comment is not blank
    @NotBlank(message = "Comment cannot be blank")
    private String comment;
    
    // Default constructor (needed for frameworks like Spring or Hibernate)
    public CommentDTO() {
    }
    
    // Constructor initializing blogId and comment
    public CommentDTO(Long blogId, String comment) {
        super(); // Calls the superclass constructor (not necessary here)
        this.blogId = blogId;
        this.comment = comment;
    }
    
    // Constructor initializing all fields including commentId
    public CommentDTO(Long commentId, Long blogId, String comment) {
        super(); // Calls the superclass constructor
        this.commentId = commentId;
        this.blogId = blogId;
        this.comment = comment;
    }

    // Getter for commentId
    public Long getCommentId() {
        return commentId;
    }

    // Setter for commentId
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    // Getter for blogId
    public Long getBlogId() {
        return blogId;
    }

    // Setter for blogId
    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    // Getter for comment
    public String getComment() {
        return comment;
    }
    
    // Setter for comment
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    // toString method for debugging/logging purposes
    @Override
    public String toString() {
        return "CommentDTO [commentId=" + commentId + ", blogId=" + blogId + ", comment=" + comment + "]";
    }
    
}
