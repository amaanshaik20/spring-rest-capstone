package com.dto;

public class BlogDTO {
	private int blogId;

	private String blogTitle;

	private String blogContent;

	public BlogDTO() {
		// TODO Auto-generated constructor stub
	}

	public BlogDTO(String blogTitle, String blogContent) {
		super();
		this.blogTitle = blogTitle;
		this.blogContent = blogContent;
	}
	
	public BlogDTO(int blogId, String blogTitle, String blogContent) {
		super();
		this.blogId = blogId;
		this.blogTitle = blogTitle;
		this.blogContent = blogContent;
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
		return "BlogDTO [blogId=" + blogId + ", blogTitle=" + blogTitle + ", blogContent=" + blogContent + "]";
	}

}
