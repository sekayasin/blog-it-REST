package edu.miu.cs544.service;

import edu.miu.cs544.dto.CommentRequest;
import edu.miu.cs544.dto.CommentUpdate;
import edu.miu.cs544.model.Comment;

import java.util.List;

public interface CommentService {
    public List<Comment> getAll();
    public List<Comment> getPostComments(Long pid);
    public Comment get(Long id);
    public Long add(CommentRequest commentReq);
    public Long update(Long id, CommentUpdate commentUpdate);
    public void delete(Long id);
    public void deletePostComments(Long id);

}
