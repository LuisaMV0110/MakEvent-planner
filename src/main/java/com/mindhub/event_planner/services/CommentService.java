package com.mindhub.event_planner.services;

import com.mindhub.event_planner.dtos.CommentDTO;
import com.mindhub.event_planner.models.Comment;

public interface CommentService extends GenericService<Comment, CommentDTO>{
    Comment findById(Long id);
}
