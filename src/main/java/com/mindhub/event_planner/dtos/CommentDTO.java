package com.mindhub.event_planner.dtos;

import com.mindhub.event_planner.models.Comment;

public class CommentDTO {

    private Long id;

    private String comment;

    public CommentDTO() {}

    public CommentDTO(Comment comment) {
        this.id = comment.getId();
        this.comment = comment.getComment();
    }

    public Long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }
}
