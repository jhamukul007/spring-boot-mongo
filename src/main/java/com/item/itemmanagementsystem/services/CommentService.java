package com.item.itemmanagementsystem.services;

import com.item.itemmanagementsystem.dtos.CommentDto;
import com.item.itemmanagementsystem.models.Post;
import org.springframework.web.bind.annotation.RequestBody;

public interface CommentService {
    Post commentOnPost(String postId, CommentDto commentDto);
    public Post replyOnComment(String commentId, @RequestBody CommentDto commentDto);
}
