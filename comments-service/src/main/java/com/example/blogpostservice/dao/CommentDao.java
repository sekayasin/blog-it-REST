package com.example.blogpostservice.dao;

import com.example.blogpostservice.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao extends JpaRepository<Comment, Long> {
    @Override
    Comment getById(Long aLong);
    List<Comment> getCommentByUser(Long id);
    List<Comment> getCommentByPost(Long id);
}