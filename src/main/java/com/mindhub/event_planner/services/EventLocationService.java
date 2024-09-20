package com.mindhub.event_planner.services;

import com.mindhub.event_planner.dtos.EventLocationDTO;
import com.mindhub.event_planner.models.EventLocation;

public interface EventLocationService extends GenericService<EventLocation, EventLocationDTO>{
    EventLocation findById (Long id);
}
