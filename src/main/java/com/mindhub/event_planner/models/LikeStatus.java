package com.mindhub.event_planner.models;

import com.mindhub.event_planner.enums.LikeEnum;
import jakarta.persistence.*;

@Entity
public class LikeStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="event_id")
    private Event event;

    private LikeEnum likeS;

    public LikeStatus() {}

    public LikeStatus(LikeEnum like) {
        this.likeS = like;
    }

    public Long getId() { return id; }

    public LikeEnum getLikeS() { return likeS; }

    public void setLikeS(LikeEnum likeS) { this.likeS = likeS; }

    public UserEntity getUser() { return user; }

    public void setUser(UserEntity user) { this.user = user; }

    public Event getEvent() { return event; }

    public void setEvent(Event event) { this.event = event; }
}
