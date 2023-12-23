package com.item.itemmanagementsystem.services.impl;

import com.item.itemmanagementsystem.dtos.CommentDto;
import com.item.itemmanagementsystem.exceptions.CommentNotFoundException;
import com.item.itemmanagementsystem.exceptions.PostNotFoundException;
import com.item.itemmanagementsystem.exceptions.UserNotFoundException;
import com.item.itemmanagementsystem.models.Comment;
import com.item.itemmanagementsystem.models.Post;
import com.item.itemmanagementsystem.models.User;
import com.item.itemmanagementsystem.services.CommentService;
import com.item.itemmanagementsystem.services.PostService;
import com.item.itemmanagementsystem.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final PostService postService;
    private final UserService userService;

    @Override
    public Post commentOnPost(String doubtId, CommentDto commentDto) {
        Post post = postService.findById(doubtId).orElseThrow(() -> new PostNotFoundException());
        User commentedBy = userService.getUserById(commentDto.getAskedBy()).orElseThrow(() -> new UserNotFoundException());

        Comment comment = Comment.builder()
                .id(UUID.randomUUID().toString())
                .text(commentDto.getText())
                .askedBy(commentedBy)
                .build();
        post.addComment(comment);
        return postService.saveOrUpdatePost(post);
    }

    @Override
    public Post replyOnComment(String commentId, CommentDto commentDto) {
        Post post = postService.getPostByComment(commentId).orElseThrow(() -> new PostNotFoundException());
        User commentedBy = userService.getUserById(commentDto.getAskedBy()).orElseThrow(() -> new UserNotFoundException());

        Comment reply = Comment.builder()
                .id(UUID.randomUUID().toString())
                .text(commentDto.getText())
                .askedBy(commentedBy)
                .build();
        Comment comment = post.getCommentById(commentId).orElseThrow(() -> new CommentNotFoundException());
        comment.addReply(reply);
        return postService.saveOrUpdatePost(post);
    }
}
