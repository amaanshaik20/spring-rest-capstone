package com.service;

import java.util.List;

import com.dto.CommentDTO;

public interface CommentService {
	public CommentDTO addComment(CommentDTO commentDTO);

	public List<String> getCommentsOf(int id);

	
	public boolean deleteComment(int commentid);

}
