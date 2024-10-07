package com.mindhub.event_planner.services;

import com.mindhub.event_planner.dtos.EventLocationDTOA;
import com.mindhub.event_planner.dtos.notAccesibleForEveryone.EventLocationDTONA;
import com.mindhub.event_planner.models.EventLocation;

import java.util.List;

public interface EventLocationService extends GenericService<EventLocation, EventLocationDTONA>{
    EventLocation findById (Long id);

    List<EventLocationDTOA> findAll2();
}
