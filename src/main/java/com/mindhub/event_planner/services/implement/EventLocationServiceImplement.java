package com.mindhub.event_planner.services.implement;

import com.mindhub.event_planner.dtos.EventLocationDTOA;
import com.mindhub.event_planner.dtos.notAccesibleForEveryone.EventLocationDTONA;
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
    public List<EventLocationDTONA> findAll() {
        return eventLocationRepository.findAll().stream().map(EventLocationDTONA::new).collect(Collectors.toList());
    }

    @Override
    public List<EventLocationDTOA> findAll2() {
        return eventLocationRepository.findAll().stream().map(EventLocationDTOA::new).collect(Collectors.toList());
    }

    @Override
    public EventLocation findById(Long id) {
        return eventLocationRepository.findById(id).orElseThrow( () -> new ObjectNotFound("The event location with the ID: " + id + " was not found"));
    }


}
