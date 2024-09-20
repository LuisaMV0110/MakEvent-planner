package com.mindhub.event_planner.services.implement;

import com.mindhub.event_planner.dtos.EventLocationDTO;
import com.mindhub.event_planner.handlers.ObjectNotFound;
import com.mindhub.event_planner.models.EventLocation;
import com.mindhub.event_planner.repositories.EventLocationRepository;
import com.mindhub.event_planner.services.EventLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventLocationServiceImplement implements EventLocationService {

    @Autowired
    EventLocationRepository eventLocationRepository;

    @Override
    public List<EventLocationDTO> findAll() {
        return eventLocationRepository.findAll().stream().map(EventLocationDTO::new).collect(Collectors.toList());
    }

    @Override
    public EventLocation findById(Long id) {
        return eventLocationRepository.findById(id).orElseThrow( () -> new ObjectNotFound("The EventLocation with the ID:" + id + " was not found"));
    }
}
