package com.mindhub.event_planner.models;

import jakarta.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="event_id")
    private Event event;

    private String comment;

    public Comment() {}

    public Comment(String comment) {
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public UserEntity getUser() { return user; }

    public void setUser(UserEntity user) { this.user = user; }

    public Event getEvent() { return event; }

    public void setEvent(Event event) { this.event = event; }
}
