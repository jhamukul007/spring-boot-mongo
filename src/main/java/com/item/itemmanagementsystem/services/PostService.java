package com.item.itemmanagementsystem.services;

import com.item.itemmanagementsystem.models.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Post createPost(String userId, Post post);

    Optional<Post> findById(String postId);

    List<Post> findPostsByUserId(String userId);

    Post saveOrUpdatePost(Post post);

    Optional<Post> getPostByComment(String commentId);
}
