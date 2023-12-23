package com.item.itemmanagementsystem.controllers;

import com.item.itemmanagementsystem.dtos.CommentDto;
import com.item.itemmanagementsystem.models.Post;
import com.item.itemmanagementsystem.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/post/{postId}")
    public Post commentOnDoubt(@PathVariable String postId, @RequestBody CommentDto commentDto) {
        return commentService.commentOnPost(postId, commentDto);
    }

    @PostMapping("/reply/{commentId}")
    public Post replyOnComment(@PathVariable String commentId, @RequestBody CommentDto commentDto) {
        return commentService.replyOnComment(commentId, commentDto);
    }

}
