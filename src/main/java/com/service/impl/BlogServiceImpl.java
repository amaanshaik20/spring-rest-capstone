package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.BlogDTO;
import com.entity.BlogEntity;
import com.exception.BlogNotFoundException;
import com.exception.CustomException;
import com.repository.BlogRepository;
import com.service.BlogService;

@Service // Marks this class as a service component in Spring
public class BlogServiceImpl implements BlogService {

	private BlogRepository blogRepository;

	// Constructor-based dependency injection for BlogRepository
	public BlogServiceImpl(BlogRepository blogRepository) {
		this.blogRepository = blogRepository;
	}

	// Fetches all blogs from the database and converts them to DTO format
	@Override
	public List<BlogDTO> getAllBlogs() {
		List<BlogDTO> blogList = new ArrayList<>();
		List<BlogEntity> list = blogRepository.findAll(); // Retrieves all blog entities
		for (BlogEntity en : list) {
			blogList.add(convertToDTO(en)); // Converts each entity to DTO
		}
		return blogList;
	}

	// Fetches a blog by its ID, throws an exception if not found
	@Override
	public BlogDTO getBlogById(Long blogId) {
		if (blogId < 0) {
			throw new CustomException("Blog ID cannot be negative");
		}
		// Retrieves the blog or throws an exception if it doesn't exist
		BlogEntity blog = blogRepository.findById(blogId)
				.orElseThrow(() -> new BlogNotFoundException("Blog not found with ID: " + blogId));
		return new BlogDTO(blog.getBlogId(), blog.getBlogTitle(), blog.getBlogContent());
	}

	// Converts BlogEntity to BlogDTO for data transfer
	private BlogDTO convertToDTO(BlogEntity blogEntity) {
		return new BlogDTO(blogEntity.getBlogId(), blogEntity.getBlogTitle(), blogEntity.getBlogContent());
	}

	// Creates a new blog and saves it to the database
	@Override
	public BlogDTO createBlog(BlogDTO blogDto) {
		BlogEntity blogEntity = new BlogEntity();
		blogEntity.setBlogTitle(blogDto.getBlogTitle());
		blogEntity.setBlogContent(blogDto.getBlogContent());

		// Saves the blog entity and returns the saved data as a DTO
		BlogEntity savedBlog = blogRepository.save(blogEntity);
		return new BlogDTO(savedBlog.getBlogId(), savedBlog.getBlogTitle(), savedBlog.getBlogContent());
	}

	// Updates an existing blog, throws an exception if the blog doesn't exist
	@Override
	public BlogDTO updateBlog(Long id, BlogDTO blogDTO) {
		if (id < 0) {
			throw new CustomException("Blog ID cannot be negative");
		}
		// Finds the blog to update or throws an exception if it's not found
		BlogEntity blog = blogRepository.findById(id)
				.orElseThrow(() -> new BlogNotFoundException("Blog not found with ID: " + id));

		// Updates blog fields
		blog.setBlogTitle(blogDTO.getBlogTitle());
		blog.setBlogContent(blogDTO.getBlogContent());

		// Saves the updated blog
		BlogEntity savedBlog = blogRepository.save(blog);
		return convertToDTO(savedBlog);
	}

	// Deletes a blog by its ID, throws an exception if the blog is not found
	@Override
	public boolean deleteBlog(Long id) {
		if (id < 0) {
			throw new CustomException("Blog ID cannot be negative");
		}
		// Retrieves the blog or throws an exception if it doesn't exist
		BlogEntity blog = blogRepository.findById(id)
				.orElseThrow(() -> new BlogNotFoundException("Blog not found with ID: " + id));

		// Deletes the blog
		blogRepository.deleteById(blog.getBlogId());
		return true;
	}
}
