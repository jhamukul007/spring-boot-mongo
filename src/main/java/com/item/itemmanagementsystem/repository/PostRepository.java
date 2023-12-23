package com.item.itemmanagementsystem.repository;

import com.item.itemmanagementsystem.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends MongoRepository<Post, String> {

    @Query(value = "{'comments.id':  ?0}")
    Optional<Post> findByCommentId(String commentId);

    @Query(value = "{'postedBy._id':  ?0}")
    List<Post> findByUserId(String postedBy);
}
