package edu.miu.cs544.controller;

import edu.miu.cs544.dto.CommentRequest;
import edu.miu.cs544.model.Comment;
import edu.miu.cs544.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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

    public ResponseEntity<Comment> getPost(@PathVariable("id") long id){
        return new ResponseEntity<>(commentService.get(id), HttpStatus.OK);
    }

    @PostMapping
    public RedirectView createPost(@RequestBody CommentRequest commentRequest){
        Long id = commentService.add(commentRequest);
        return new RedirectView("redirect:/comments/"+id);
    }
    @PutMapping
    public RedirectView updateComment(@PathVariable("id") long id, @RequestBody CommentRequest commentRequest){
        commentService.update(id, commentRequest);
        return new RedirectView("redirect:/comments/"+id);
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
