package edu.miu.cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BlogRestController {

    @Autowired
    private BlogService blogService;



    @GetMapping(path = "/blogs")
    public List<BlogPost> getBlogs() {
        return blogService.getBlogs();
    }

//    @GetMapping(path = "/blogs/{id}")
//    public BlogPost getBlogById(@PathVariable Long id) {
//        return blogService.getBlogById(id);
//    }

    @GetMapping(path = "/blogs/{id}")
    public BlogPostResponse getFullBlogById(@PathVariable Long id) {
        return blogService.getFullBlogPostById(id);
    }

    @PostMapping(path = "/blogs")
    public RedirectView addBlogPost(@RequestBody BlogPost blogPost) {
        blogService.addBlogPost(blogPost);
        return new RedirectView("/api/v1/blogs/" + blogPost.getId());
    }

    @DeleteMapping(path = "/blogs/{id}")
    public void deleteStudent(@PathVariable("id") Long id){
        blogService.deleteBlog(id);
    }




}
