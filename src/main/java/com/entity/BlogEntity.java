package com.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="blogs")
public class BlogEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int blogId;
	
	private String blogTitle;
	
	private String blogContent;
	@OneToMany(mappedBy = "blogEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<CommentEntity> commentsList;
	public List<CommentEntity> getCommentsList() {
		return commentsList;
	}
	public void setCommentsList(List<CommentEntity> commentsList) {
		this.commentsList = commentsList;
	}
	
	public BlogEntity(String blogTitle, String blogContent) {
		super();
		this.blogTitle = blogTitle;
		this.blogContent = blogContent;
	}
	public BlogEntity() {
		// TODO Auto-generated constructor stub
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogContent() {
		return blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}
	@Override
	public String toString() {
		return "BlogEntity [blogId=" + blogId + ", blogTitle=" + blogTitle + ", blogContent=" + blogContent;
	}
	
	
}
