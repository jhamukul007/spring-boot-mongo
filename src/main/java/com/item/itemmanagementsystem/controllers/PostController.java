package com.item.itemmanagementsystem.controllers;

import com.item.itemmanagementsystem.models.Post;
import com.item.itemmanagementsystem.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/{userId}")
    public Post createDoubt(@PathVariable("userId") String userId, @RequestBody Post post) {
        return postService.createPost(userId, post);
    }

    @GetMapping("/{userId}")
    public List<Post> getAllPostByUserId(String userId) {
        return postService.findPostsByUserId(userId);
    }
}
