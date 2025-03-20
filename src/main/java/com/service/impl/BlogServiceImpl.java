package com.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.dto.BlogDTO;
import com.entity.BlogEntity;
import com.exception.BlogNotFoundException;
import com.repository.BlogRepository;
import com.service.BlogService;

@Service 
@Validated 
public class BlogServiceImpl implements BlogService {

	// Automatically injects the BlogRepository instance
    @Autowired 
    private BlogRepository blogRepository;
    
    // Constructor-based injection for BlogRepository
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    // Fetches all blogs and converts them to DTO format
    public List<BlogDTO> getAllBlogs() {
        List<BlogDTO> blogList = new ArrayList<>();
        List<BlogEntity> list = blogRepository.findAll();
        for (BlogEntity en : list) {
            blogList.add(convertToDTO(en));
        }
        return blogList;
    }

    // Fetches a blog by its ID, throws exception if not found
    public BlogDTO getBlogById(int blogId) {
        Optional<BlogEntity> list = blogRepository.findById(blogId);
        return list.map(e -> new BlogDTO(e.getBlogId(), e.getBlogTitle(), e.getBlogContent()))
                .orElseThrow(() -> new BlogNotFoundException("Blog not found with ID: " + blogId));
    }

    // Converts BlogEntity to BlogDTO
    private BlogDTO convertToDTO(BlogEntity blogEntity) {
        return new BlogDTO(blogEntity.getBlogId(), blogEntity.getBlogTitle(), blogEntity.getBlogContent());
    }

    // Creates a new blog and saves it to the repository
    public BlogDTO createBlog(BlogDTO blogDto) {
        BlogEntity blogEntity = new BlogEntity();
        blogEntity.setBlogTitle(blogDto.getBlogTitle());
        blogEntity.setBlogContent(blogDto.getBlogContent());
        BlogEntity savedBlog = blogRepository.save(blogEntity);
        return new BlogDTO(savedBlog.getBlogId(), savedBlog.getBlogTitle(), savedBlog.getBlogContent());
    }

    // Updates an existing blog, throws exception if not found
    public BlogDTO updateBlog(int id, BlogDTO blogDTO) {
        BlogEntity blog = blogRepository.findById(id)
                .orElseThrow(() -> new BlogNotFoundException("Blog not found with ID: " + id));
        blog.setBlogTitle(blogDTO.getBlogTitle());
        blog.setBlogContent(blogDTO.getBlogContent());
        BlogEntity savedBlog = blogRepository.save(blog);
        return convertToDTO(savedBlog);
    }

    
    // Deletes a blog by its ID, throws exception if not found
    public boolean deleteBlog(int id) {
        BlogEntity blog = blogRepository.findById(id)
                .orElseThrow(() -> new BlogNotFoundException("Blog not found with ID: " + id));
        blogRepository.deleteById(blog.getBlogId());
        return true;
    }
    

    

    
}
