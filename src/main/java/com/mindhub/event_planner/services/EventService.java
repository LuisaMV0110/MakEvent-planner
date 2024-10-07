package com.mindhub.event_planner.services;

import com.mindhub.event_planner.dtos.EventDTOA;
import com.mindhub.event_planner.dtos.create.CreateEventDTO;
import com.mindhub.event_planner.dtos.notAccesibleForEveryone.EventDTONA;
import com.mindhub.event_planner.models.Event;
import com.mindhub.event_planner.models.Manager;

import java.util.List;

public interface EventService extends GenericService<Event, EventDTONA>{
    Event findById(Long id);

    void createEvent(CreateEventDTO createEventDTO, Manager manager);

    List<EventDTOA> findAll2();
}
