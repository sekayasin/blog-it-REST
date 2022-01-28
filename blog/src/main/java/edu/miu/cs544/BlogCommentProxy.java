package edu.miu.cs544;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "BlogComment-Service", url = "localhost:8081")
public interface BlogCommentProxy {
    @GetMapping("/comments/posts/{id}")
    public List<CommentResponse> getPostComments(@PathVariable("id") long postId);

}
