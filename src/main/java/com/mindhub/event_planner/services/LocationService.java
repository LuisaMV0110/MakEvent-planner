package com.mindhub.event_planner.services;

import com.mindhub.event_planner.dtos.LocationDTO;
import com.mindhub.event_planner.models.Location;

import java.util.List;

public interface LocationService extends GenericService<Location, LocationDTO>{
    Location findById (Long id);

}
