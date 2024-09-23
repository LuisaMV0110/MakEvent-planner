package com.mindhub.event_planner.services;

import com.mindhub.event_planner.dtos.EventDTOA;
import com.mindhub.event_planner.dtos.NotAccesibleForEveryone.EventDTONA;
import com.mindhub.event_planner.models.Event;

import java.util.List;

public interface EventService extends GenericService<Event, EventDTONA>{
    Event findById(Long id);

    List<EventDTOA> findAll2();
}
