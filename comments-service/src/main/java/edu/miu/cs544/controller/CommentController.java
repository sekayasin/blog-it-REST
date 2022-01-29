package edu.miu.cs544.controller;

import edu.miu.cs544.dto.CommentRequest;
import edu.miu.cs544.dto.CommentUpdate;
import edu.miu.cs544.model.Comment;
import edu.miu.cs544.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    private final CommentService commentService;


    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComments(){
        return commentService.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Comment> getPost(@PathVariable("id") long id){
        return new ResponseEntity<>(commentService.get(id), HttpStatus.OK);
    }

    @PostMapping
    public RedirectView createPost(@RequestBody CommentRequest commentRequest){
        Long id = commentService.add(commentRequest);
        return new RedirectView("/api/v1/comments/"+id);
    }
    @PutMapping("{id}")
    public RedirectView updateComment(@PathVariable("id") long id, @RequestBody CommentUpdate commentUpdate){
        commentService.update(id, commentUpdate);
        return new RedirectView("/api/v1/comments/"+id);
    }
    @DeleteMapping("{id}")
    public void deleteComment(@PathVariable("id") long id){
        commentService.delete(id);
    }

    @GetMapping("posts/{pid}")
    public List<Comment> getPostComments(@PathVariable("pid") long pid){
        return commentService.getPostComments(pid);
    }

    @DeleteMapping("posts/{pid}")
    public void deleteCommentByPost(@PathVariable("pid") long pid){
        commentService.deletePostComments(pid);
    }


}
