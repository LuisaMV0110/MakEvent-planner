package com.mindhub.event_planner.dtos;

import com.mindhub.event_planner.enums.LikeEnum;
import com.mindhub.event_planner.models.LikeStatus;

public class LikeDTO {

    private Long id;

    private LikeEnum likeS;

    public LikeDTO() {}

    public LikeDTO(LikeStatus likeStatus) {
        this.id = likeStatus.getId();
        this.likeS = likeStatus.getLikeS();
    }

    public Long getId() {
        return id;
    }

    public LikeEnum getLikeS() {
        return likeS;
    }
}
