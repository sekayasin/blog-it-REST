package com.example.blogpostservice.controller;

import com.example.blogpostservice.dto.CommentRequest;
import com.example.blogpostservice.model.Comment;
import com.example.blogpostservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
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
    public Comment getPost(@PathVariable("id") long id){
        return commentService.get(id);
    }

    @PostMapping
    public String createPost(@RequestBody CommentRequest commentRequest){
        Long id = commentService.add(commentRequest);
        return "redirect:/comments/"+id;
    }
    @PutMapping
    public String updateComment(@PathVariable("id") long id, @RequestBody CommentRequest commentRequest){
        commentService.update(id, commentRequest);
        return "redirect:/comments/"+id;
    }
    @DeleteMapping
    public void deleteComment(@PathVariable("id") long id){
        commentService.delete(id);
    }

    @GetMapping("posts/{pid}")
    public List<Comment> getPostComments(@PathVariable("pid") long pid){
        return commentService.getPostComments(pid);
    }


}
