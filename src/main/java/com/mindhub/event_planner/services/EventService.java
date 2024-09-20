package com.mindhub.event_planner.services;

import com.mindhub.event_planner.dtos.EventDTO;
import com.mindhub.event_planner.models.Event;

public interface EventService extends GenericService<Event, EventDTO>{
    Event findById(Long id);
}
