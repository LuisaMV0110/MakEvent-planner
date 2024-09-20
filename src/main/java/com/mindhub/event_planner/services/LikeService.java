package com.mindhub.event_planner.services;

import com.mindhub.event_planner.dtos.LikeDTO;
import com.mindhub.event_planner.models.LikeStatus;

public interface LikeService extends GenericService<LikeStatus, LikeDTO>{
    LikeStatus findById (Long id);
}
