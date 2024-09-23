package com.mindhub.event_planner.services.implement;

import com.mindhub.event_planner.dtos.EventDTOA;
import com.mindhub.event_planner.dtos.NotAccesibleForEveryone.EventDTONA;
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
    public List<EventDTOA> findAll2() {
        return eventRepository.findAll().stream().map(EventDTOA::new).collect(Collectors.toList());
    }

    @Override
    public List<EventDTONA> findAll() {
        return eventRepository.findAll().stream().map(EventDTONA::new).collect(Collectors.toList());
    }


}
