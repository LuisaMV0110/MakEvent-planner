package com.mindhub.event_planner.dtos;

import com.mindhub.event_planner.enums.LikeEnum;
import com.mindhub.event_planner.models.LikeStatus;

public class LikeDTOA {

    private Long id;

    private LikeEnum likeS;

    private UserDTOA user;

    private EventDTOA event;

    public LikeDTOA() {}

    public LikeDTOA(LikeStatus likeStatus) {
        this.id = likeStatus.getId();
        this.likeS = likeStatus.getLikeS();
        this.user = new UserDTOA(likeStatus.getUser());
        this.event = new EventDTOA(likeStatus.getEvent());
    }

    public Long getId() {
        return id;
    }

    public LikeEnum getLikeS() {
        return likeS;
    }

    public UserDTOA getUser() { return user; }

    public EventDTOA getEvent() { return event; }
}
