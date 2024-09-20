package com.mindhub.event_planner.controllers;

import com.mindhub.event_planner.dtos.LocationDTO;
import com.mindhub.event_planner.models.Location;
import com.mindhub.event_planner.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    @Autowired
    LocationService locationService;

    @GetMapping("/all")
    public List<LocationDTO> getAll(){
        return locationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(new LocationDTO(locationService.findById(id)), HttpStatus.OK);
    }
}
