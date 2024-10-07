package com.mindhub.event_planner.dtos.notAccesibleForEveryone;

import com.mindhub.event_planner.enums.LikeEnum;
import com.mindhub.event_planner.models.LikeStatus;

public class LikeDTONA {

    private Long id;

    private LikeEnum likeS;

    private UserDTONA user;

    private EventDTONA event;

    public LikeDTONA() {}

    public LikeDTONA(LikeStatus likeStatus) {
        this.id = likeStatus.getId();
        this.likeS = likeStatus.getLikeS();
        this.user = new UserDTONA(likeStatus.getUser());
        this.event = new EventDTONA(likeStatus.getEvent());
    }

    public Long getId() {
        return id;
    }

    public LikeEnum getLikeS() {
        return likeS;
    }

    public UserDTONA getUser() { return user; }

    public EventDTONA getEvent() { return event; }
}
