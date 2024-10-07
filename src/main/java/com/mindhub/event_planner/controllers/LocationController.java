package com.mindhub.event_planner.controllers;

import com.mindhub.event_planner.dtos.LocationDTO;
import com.mindhub.event_planner.models.Location;
import com.mindhub.event_planner.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping("/auth/create")
    public ResponseEntity<String> createLocation (@RequestBody Location location){
        if(location.getName().isBlank()){
            return ResponseEntity.badRequest().body("The name of the location is missing");
        }
        if(location.getLocation().isBlank()){
            return ResponseEntity.badRequest().body("The location is missing");
        }
        if(location.getImg().isBlank()){
            return ResponseEntity.badRequest().body("The image of the location is missing");
        }
        if(location.getCapacity() <= 0){
            return ResponseEntity.badRequest().body("Please enter a valid capacity number");
        }

        locationService.createLocation(location);
        return ResponseEntity.ok("Location created successfully");
    }

    @GetMapping("/all")
    public List<LocationDTO> getAll(){
        return locationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(new LocationDTO(locationService.findById(id)), HttpStatus.OK);
    }
}
