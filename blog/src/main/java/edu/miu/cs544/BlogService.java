package edu.miu.cs544;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
//@RequiredArgsConstructor
public class BlogService {

    @Autowired
    private BlogDao blogDao;
    @Autowired
    private ModelMapper modelMapper;

//    @Autowired
    private BlogCommentProxy blogCommentProxy;
    @Autowired
    private UserAuthProxy userAuthProxy;

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

    public UserResponse getUser(HttpHeaders headers){
//        UserResponse userResponse =
        return modelMapper.map(userAuthProxy.getUser(headers).getBody(),UserResponse.class);
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
