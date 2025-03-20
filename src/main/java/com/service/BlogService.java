package com.service;

import java.util.List;

import com.dto.BlogDTO;

public interface BlogService {
	public List<BlogDTO> getAllBlogs();

	public BlogDTO getBlogById(int blogId);

	public BlogDTO createBlog(BlogDTO blogDto);

	public BlogDTO updateBlog(int id, BlogDTO blogDTO);

	public boolean deleteBlog(int id);

}
