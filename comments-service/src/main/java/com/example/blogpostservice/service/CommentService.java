package com.example.blogpostservice.service;

import com.example.blogpostservice.dto.CommentRequest;
import com.example.blogpostservice.model.Comment;

import java.util.List;

public interface CommentService {
    public List<Comment> getAll();
    public List<Comment> getPostComments(Long pid);
    public Comment get(Long id);
    public Long add(CommentRequest commentReq);
    public Long update(Long id, CommentRequest commentReq);
    public void delete(Long id);

}
