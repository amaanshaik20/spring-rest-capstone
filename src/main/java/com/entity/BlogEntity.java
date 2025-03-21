package com.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity // Marks this class as a JPA entity (table representation in the database)
@Table(name="blogs") // Specifies the table name in the database
public class BlogEntity {
    
    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates unique values for the primary key
//    @Column(name = "blogId")   //this will define a name for the column in the database.
    private Long blogId;
    
    private String blogTitle;
    
    private String blogContent;
    
    // One-to-Many relationship with CommentEntity
    // mappedBy specifies the field in CommentEntity that maps this relationship
    // cascade = CascadeType.ALL ensures related comments are automatically deleted
    // fetch = FetchType.LAZY means comments are loaded only when explicitly accessed
    @OneToMany(mappedBy = "blogEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CommentEntity> commentsList;
    
    // Getter for comments list
    public List<CommentEntity> getCommentsList() {
        return commentsList;
    }
    
    // Setter for comments list
    public void setCommentsList(List<CommentEntity> commentsList) {
        this.commentsList = commentsList;
    }
    
    // Constructor with title and content
    public BlogEntity(String blogTitle, String blogContent) {
        super(); // Calls the superclass constructor (not necessary here)
        this.blogTitle = blogTitle;
        this.blogContent = blogContent;
    }
    
    // Constructor with all fields including ID
    public BlogEntity(Long blogId, String blogTitle, String blogContent) {
        super(); // Calls the superclass constructor
        this.blogId = blogId;
        this.blogTitle = blogTitle;
        this.blogContent = blogContent;
    }
    
    // Default constructor (required by JPA)
    public BlogEntity() {
        // TODO Auto-generated constructor stub
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
        return "BlogEntity [blogId=" + blogId + ", blogTitle=" + blogTitle + ", blogContent=" + blogContent + "]";
    }
    
}
