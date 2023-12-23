package com.item.itemmanagementsystem.services.impl;

import com.item.itemmanagementsystem.exceptions.UserNotFoundException;
import com.item.itemmanagementsystem.models.Post;
import com.item.itemmanagementsystem.models.User;
import com.item.itemmanagementsystem.repository.PostRepository;
import com.item.itemmanagementsystem.services.PostService;
import com.item.itemmanagementsystem.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserService userService;

    @Override
    public Post createPost(String userId, Post post) {
        User postedBy = userService.getUserById(userId).orElseThrow(() -> new UserNotFoundException());
        post.setPostedBy(postedBy);
        return postRepository.save(post);
    }

    @Override
    public Optional<Post> findById(String postId) {
        return postRepository.findById(postId);
    }

    @Override
    public List<Post> findPostsByUserId(String userId) {
        return postRepository.findByUserId(userId);
    }

    @Override
    public Post saveOrUpdatePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Optional<Post> getPostByComment(String commentId) {
        return postRepository.findByCommentId(commentId);
    }
}
