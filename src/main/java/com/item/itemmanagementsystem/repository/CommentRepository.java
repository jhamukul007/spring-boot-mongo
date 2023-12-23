package com.item.itemmanagementsystem.repository;

import com.item.itemmanagementsystem.models.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
}
