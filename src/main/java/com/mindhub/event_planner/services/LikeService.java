package com.mindhub.event_planner.services;

import com.mindhub.event_planner.dtos.LikeDTOA;
import com.mindhub.event_planner.dtos.notAccesibleForEveryone.LikeDTONA;
import com.mindhub.event_planner.models.LikeStatus;

import java.util.List;

public interface LikeService extends GenericService<LikeStatus, LikeDTONA>{
    LikeStatus findById (Long id);

    List<LikeDTOA> findAll2();
};
