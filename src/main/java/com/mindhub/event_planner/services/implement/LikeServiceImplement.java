package com.mindhub.event_planner.services.implement;

import com.mindhub.event_planner.dtos.LikeDTO;
import com.mindhub.event_planner.handlers.ObjectNotFound;
import com.mindhub.event_planner.models.LikeStatus;
import com.mindhub.event_planner.repositories.LikeRepository;
import com.mindhub.event_planner.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LikeServiceImplement implements LikeService {

    @Autowired
    LikeRepository likeRepository;

    @Override
    public List<LikeDTO> findAll() {
        return likeRepository.findAll().stream().map(LikeDTO::new).collect(Collectors.toList());
    }

    @Override
    public LikeStatus findById(Long id) {
        return likeRepository.findById(id).orElseThrow( () -> new ObjectNotFound("The Like with the ID:" + id + " was not found"));
    }
}
