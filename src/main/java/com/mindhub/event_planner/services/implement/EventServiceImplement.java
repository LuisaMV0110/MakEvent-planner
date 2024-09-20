package com.mindhub.event_planner.services.implement;

import com.mindhub.event_planner.dtos.EventDTO;
import com.mindhub.event_planner.handlers.ObjectNotFound;
import com.mindhub.event_planner.models.Event;
import com.mindhub.event_planner.repositories.EventRepository;
import com.mindhub.event_planner.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImplement implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event findById(Long id) {
        return eventRepository.findById(id).orElseThrow( () -> new ObjectNotFound("The Event with the ID:" + id + " was not found"));
    }

    @Override
    public List<EventDTO> findAll() {
        return eventRepository.findAll().stream().map(EventDTO::new).collect(Collectors.toList());
    }
}
