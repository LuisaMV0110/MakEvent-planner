package com.mindhub.event_planner.services.implement;

import com.mindhub.event_planner.dtos.CommentDTOA;
import com.mindhub.event_planner.dtos.notAccesibleForEveryone.CommentDTONA;
import com.mindhub.event_planner.handlers.ObjectNotFound;
import com.mindhub.event_planner.models.Comment;
import com.mindhub.event_planner.repositories.CommentRepository;
import com.mindhub.event_planner.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImplement implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElseThrow( () -> new ObjectNotFound("The comment with the ID: " + id + " was not found"));
    }

    @Override
    public List<CommentDTOA> findAll2() {
        return commentRepository.findAll().stream().map(CommentDTOA::new).collect(Collectors.toList());
    }

    @Override
    public List<CommentDTONA> findAll() {
        return commentRepository.findAll().stream().map(CommentDTONA::new).collect(Collectors.toList());
    }

}
