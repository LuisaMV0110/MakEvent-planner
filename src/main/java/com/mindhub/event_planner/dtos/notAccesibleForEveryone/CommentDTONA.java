package com.mindhub.event_planner.dtos.notAccesibleForEveryone;

import com.mindhub.event_planner.models.Comment;

public class CommentDTONA {

    private Long id;

    private String comment;

    private UserDTONA user;

    private EventDTONA event;

    public CommentDTONA() {
    }

    public CommentDTONA(Comment comment) {
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.user = new UserDTONA(comment.getUser());
        this.event = new EventDTONA(comment.getEvent());
    }

    public Long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public UserDTONA getUser() {
        return user;
    }

    public EventDTONA getEvent(){ return event; }
}
