package com.mindhub.event_planner.services;

import com.mindhub.event_planner.dtos.LocationDTOA;
import com.mindhub.event_planner.dtos.NotAccesibleForEveryone.LocationDTONA;
import com.mindhub.event_planner.models.Location;

import java.util.List;

public interface LocationService extends GenericService<Location, LocationDTONA>{
    Location findById (Long id);

    List<LocationDTOA> findAll2();
}
