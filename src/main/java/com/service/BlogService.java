package com.service;

import java.util.List;

import com.dto.BlogDTO;

public interface BlogService {
	public List<BlogDTO> getAllBlogs();

	public BlogDTO getBlogById(Long blogId);

	public BlogDTO createBlog(BlogDTO blogDto);

	public BlogDTO updateBlog(Long id, BlogDTO blogDTO);

	public boolean deleteBlog(Long id);

}
