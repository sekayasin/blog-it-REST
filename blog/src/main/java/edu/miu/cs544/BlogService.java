package edu.miu.cs544;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogDao blogDao;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BlogCommentProxy blogCommentProxy;

    public List<BlogPost> getBlogs() {
        return blogDao.findAll();
    }

    public BlogPost getBlogById(Long id) {

        return blogDao.findById(id)
                .orElseThrow(() -> new IllegalStateException("BlogPost with id " + id + " does not exist"));
    }

    public BlogPostResponse getFullBlogPostById(Long id){
        BlogPost blogPost = blogDao.findById(id)
                .orElseThrow(() -> new IllegalStateException("BlogPost with id " + id + " does not exist"));
        BlogPostResponse postResponse = modelMapper.map(blogPost, BlogPostResponse.class);
        List<CommentResponse> commentList = blogCommentProxy.getPostComments(id);
        postResponse.setComments(commentList);
        return postResponse;
    }

    public void addBlogPost(BlogPost blogPost) {
        blogDao.save(blogPost);
    }

    public void deleteBlog(Long id) {
        boolean exists = blogDao.existsById(id);
        if (!exists) {
            throw new IllegalStateException("BlogPost with id " + id + " does not exist");
        }
        blogDao.deleteById(id);
    }




}
