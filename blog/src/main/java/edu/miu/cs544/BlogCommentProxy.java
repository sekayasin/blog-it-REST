package edu.miu.cs544;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "BlogComment-Service", url = "localhost:8081")
//@FeignClient(name = "Blog-Comment-Service", url = "blog-comment-service:8081")
public interface BlogCommentProxy {
    @GetMapping("/api/v1/comments/posts/{id}")
    public List<CommentResponse> getPostComments(@PathVariable("id") long postId);

}
