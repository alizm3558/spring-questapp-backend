package com.example.questapp.controllers;

import com.example.questapp.entities.Comment;
import com.example.questapp.entities.Post;
import com.example.questapp.requests.CommentCreateRequest;
import com.example.questapp.requests.CommentUptadeRequest;
import com.example.questapp.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId,@RequestParam Optional<Long> postId){
        return commentService.getAllCommentsWithParam(userId,postId);
    }

    @GetMapping("/{commentId}")
    public Comment getOneComment(@PathVariable Long commentId){
        return  commentService.getOneCommentById(commentId);
    }


    @PostMapping
    public Comment createOneComment(@RequestBody CommentCreateRequest commentCreateRequest){
        return commentService.createOneComment(commentCreateRequest);

    }

    @PutMapping
    public Comment updateOneComment(@PathVariable Long commentId,@RequestBody CommentUptadeRequest commentUptadeRequest){
        return  commentService.updateOneCommentById(commentId,commentUptadeRequest);
    }

    @DeleteMapping("/{commentId}")
    public void deleteOneCOmment(@PathVariable Long commentId){
         commentService.deleteOneCommentById(commentId);
    }

}
