package com.mindhub.event_planner.services;

import com.mindhub.event_planner.dtos.CommentDTOA;
import com.mindhub.event_planner.dtos.notAccesibleForEveryone.CommentDTONA;
import com.mindhub.event_planner.models.Comment;

import java.util.List;

public interface CommentService extends GenericService<Comment, CommentDTONA>{
    Comment findById(Long id);

    List<CommentDTOA> findAll2();
}
