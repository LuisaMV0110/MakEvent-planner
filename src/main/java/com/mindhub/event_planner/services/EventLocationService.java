package com.mindhub.event_planner.services;

import com.mindhub.event_planner.dtos.EventLocationDTOA;
import com.mindhub.event_planner.dtos.notAccesibleForEveryone.EventLocationDTONA;
import com.mindhub.event_planner.models.Event;
import com.mindhub.event_planner.models.EventLocation;
import com.mindhub.event_planner.models.Location;

import java.util.List;

public interface EventLocationService extends GenericService<EventLocation, EventLocationDTONA>{
    EventLocation findById (Long id);

    List<EventLocationDTOA> findAll2();

    void createEventLocation(EventLocation eventLocation, Event event, Location location);
}
