package com.item.itemmanagementsystem.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Document(collection = "post")
@Data
public class Post {
    @Id
    private String id;
    private String text;
    private User postedBy;
    private List<Comment> comments = new ArrayList<>();

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public Optional<Comment> getCommentById(String id) {
        return this.comments.stream().filter(comment -> Objects.deepEquals(id, comment.getId())).findAny();
    }
}
