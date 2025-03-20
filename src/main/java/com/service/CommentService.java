package com.service;

import java.util.List;

import com.dto.CommentDTO;

import jakarta.validation.Valid;

public interface CommentService {
	public CommentDTO addComment(CommentDTO commentDTO);

	public List<String> getCommentsOf(Long id);

	public boolean deleteComment(Long commentid);

	public CommentDTO updateBlog(Long commentid, @Valid CommentDTO commentDTO);

}
