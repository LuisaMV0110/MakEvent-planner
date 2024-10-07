package com.mindhub.event_planner.services;

import com.mindhub.event_planner.dtos.LocationDTO;
import com.mindhub.event_planner.models.Location;

public interface LocationService extends GenericService<Location, LocationDTO>{
    Location findById (Long id);

    void createLocation (Location location);

}
