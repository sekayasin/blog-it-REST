package edu.miu.cs544.service;

import edu.miu.cs544.dao.CommentDao;
import edu.miu.cs544.dto.CommentRequest;
import edu.miu.cs544.dto.CommentUpdate;
import edu.miu.cs544.model.Comment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    private final CommentDao postDao;
    private final ModelMapper modelMapper;

    @Autowired
    public CommentServiceImpl(CommentDao postDao, ModelMapper modelMapper) {
        this.postDao = postDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Comment> getAll() {
        return postDao.findAll();
    }

    @Override
    public List<Comment> getPostComments(Long pid) {
        return postDao.getCommentByPost(pid);
    }

    @Override
    public Comment get(Long id) {
        return postDao.getById(id);
    }

    @Override
    public Long add(CommentRequest postReq) {
        return postDao.save(modelMapper.map(postReq, Comment.class)).getId();
    }

    @Override
    public Long update(Long id, CommentUpdate updateReq) {
        if(!postDao.existsById(id))
            throw new IllegalStateException();
        Comment comment = postDao.getById(id);
        comment.setContent(updateReq.getContent());
        postDao.save(comment);
        return id;
    }

    @Override
    public void delete(Long id) {
        if(!postDao.existsById(id))
            throw new IllegalStateException();
        postDao.deleteById(id);
    }

    @Override
    public void deletePostComments(Long id){
        postDao.deleteCommentByPost(id);
    }
}
