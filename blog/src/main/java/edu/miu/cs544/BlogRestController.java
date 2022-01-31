package edu.miu.cs544;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@Slf4j
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
    public ResponseEntity<Object> addBlogPost(@RequestBody BlogPost blogPost, @RequestHeader HttpHeaders headers) {
        if (headers.containsKey("Authorization")){

            //Here we do logic depending on the response from auth service
            log.info("UserLogged in, {}",blogService.getUser(headers));

            blogService.addBlogPost(blogPost);
            return new ResponseEntity<>(blogPost,HttpStatus.CREATED);
        }

        return new ResponseEntity<>(ErrorResponse.builder().message("Missing Auth Token").status("403").build(),HttpStatus.FORBIDDEN);

    }

    @PutMapping(path = "/blogs/{id}")
    public void updateBlogPost(@PathVariable("id") Long id, @RequestBody BlogPostUpdate blogPostUpdate) {
        blogService.updateBlogPost(id, blogPostUpdate);
    }

    @DeleteMapping(path = "/blogs/{id}")
    public void deleteStudent(@PathVariable("id") Long id){
        blogService.deleteBlog(id);
    }




}
