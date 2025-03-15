package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.BlogDTO;
import com.entity.BlogEntity;
import com.exception.BlogNotFoundException;
import com.repository.BlogRepository;

@Service
public class BlogService {
	private List<BlogDTO> blogList = new ArrayList<>();
	
	@Autowired
	private BlogRepository blogRepository;
	
	
	public List<BlogDTO> getAllBlogs() {
		List<BlogEntity> list=blogRepository.findAll();
		for(BlogEntity en:list) {
			blogList.add(convertToDTO(en));
		}
		return blogList;
	}
	 public BlogDTO getBlogById(int blogId) {
	        Optional<BlogEntity> list = blogRepository.findById(blogId);
	        return list.map(e -> new BlogDTO(e.getBlogId(), e.getBlogTitle(), e.getBlogContent()))
	                           .orElseThrow(() -> new BlogNotFoundException("Blog not found with ID: " + blogId));
	    }
	
	private BlogDTO convertToDTO(BlogEntity blogEntity) {
        return new BlogDTO(blogEntity.getBlogId(), blogEntity.getBlogTitle(), blogEntity.getBlogContent());
    }
	
//	private BlogEntity convertToEntity(BlogDTO blogDTO) {
//		return new BlogEntity(blogDTO.getBlogTitle(), blogDTO.getBlogContent());
//	}
	

}