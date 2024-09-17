package com.mindhub.event_planner.models;

import com.mindhub.event_planner.enums.LikeEnum;
import jakarta.persistence.*;

@Entity
public class LikeStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeStatus_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private Customer user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="event_id")
    private Event event;

    private LikeEnum likeS;

    public LikeStatus() {}

    public LikeStatus(LikeEnum like) {
        this.likeS = like;
    }

    public Long getLike_id() { return likeStatus_id; }

    public Customer getUser_id() {
        return user;
    }

    public void setUser(Customer user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public LikeEnum getLike() {
        return likeS;
    }

    public void setLike(LikeEnum like) {
        this.likeS = like;
    }

    @Override
    public String toString() {
        return "Like{" +
                "LikeStatus_id=" + likeStatus_id +
                ", user_id=" + user+
                ", event_id=" + event +
                ", like=" + likeS +
                '}';
    }
}
