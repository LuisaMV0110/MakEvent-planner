package com.mindhub.event_planner.services.implement;

import com.mindhub.event_planner.dtos.LocationDTO;
import com.mindhub.event_planner.handlers.ObjectNotFound;
import com.mindhub.event_planner.models.Location;
import com.mindhub.event_planner.repositories.LocationRepository;
import com.mindhub.event_planner.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImplement implements LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Override
    public List<LocationDTO> findAll() {
        return locationRepository.findAll().stream().map(LocationDTO::new).collect(Collectors.toList());
    }

    @Override
    public Location findById(Long id) {
        return locationRepository.findById(id).orElseThrow( () -> new ObjectNotFound("The location with the ID: " + id + " was not found"));
    }

}
