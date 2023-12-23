package com.item.itemmanagementsystem.models;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Comment {
    private String id;
    private String text;
    private User askedBy;
    @Builder.Default
    private List<Comment> reply = new ArrayList<>();

    public void addReply(Comment reply) {
        if(this.reply == null) this.reply = new ArrayList<>();
        this.reply.add(reply);
    }
}
