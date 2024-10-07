package com.mindhub.event_planner.dtos;

import com.mindhub.event_planner.models.Comment;

public class CommentDTOA {

    private Long id;

    private String comment;

    private UserDTOA user;

    private EventDTOA event;

    public CommentDTOA() {}

    public CommentDTOA(Comment comment) {
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.user = new UserDTOA(comment.getUser());
        this.event = new EventDTOA(comment.getEvent());
    }

    public Long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public UserDTOA getUser() {
        return user;
    }

    public EventDTOA getEvent() { return event; }
}
