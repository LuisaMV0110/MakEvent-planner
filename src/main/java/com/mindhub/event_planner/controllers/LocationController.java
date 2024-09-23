package com.mindhub.event_planner.controllers;

import com.mindhub.event_planner.dtos.LocationDTOA;
import com.mindhub.event_planner.dtos.NotAccesibleForEveryone.LocationDTONA;
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

    @GetMapping("/authAM/all")
    public List<LocationDTONA> getAll(){
        return locationService.findAll();
    }

    @GetMapping("/authU/all")
    public List<LocationDTOA> getAll2(){
        return locationService.findAll2();
    }

    @GetMapping("/authAM/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(new LocationDTONA(locationService.findById(id)), HttpStatus.OK);
    }

    @GetMapping("/authU/{id}")
    public ResponseEntity<?> getById2(@PathVariable Long id){
        return new ResponseEntity<>(new LocationDTOA(locationService.findById(id)), HttpStatus.OK);
    }
}
