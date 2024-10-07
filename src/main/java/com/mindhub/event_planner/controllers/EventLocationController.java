package com.mindhub.event_planner.controllers;

import com.mindhub.event_planner.dtos.EventLocationDTOA;
import com.mindhub.event_planner.dtos.notAccesibleForEveryone.EventLocationDTONA;
import com.mindhub.event_planner.models.*;
import com.mindhub.event_planner.services.CustomerService;
import com.mindhub.event_planner.services.EventLocationService;
import com.mindhub.event_planner.services.EventService;
import com.mindhub.event_planner.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventLocation")
public class EventLocationController {

    @Autowired
    private EventLocationService eventLocationService;

    @Autowired
    private EventService eventService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private CustomerService customerService;

    @PostMapping("/auth/create")
    public ResponseEntity<String> createEventLocation(@RequestBody EventLocation eventLocation, Authentication authentication, @RequestParam Long idEvent, @RequestParam Long idLocation){
        Customer manager = customerService.findByEmail(authentication.getName());
        Event event = eventService.findById(idEvent);
        Location location = locationService.findById(idLocation);

        if(eventLocation.getDate() == null){
            return ResponseEntity.badRequest().body("The date of the event is missing");
        }
        if(eventLocation.getAssistance() <= 0){
            return ResponseEntity.badRequest().body("Please enter a valid assistance number");
        }
        if(event == null){
            return ResponseEntity.badRequest().body("The event with the ID: " + idEvent + " was not found");
        }
        if(!event.getManager().equals(manager)){
            return ResponseEntity.badRequest().body("The event with the ID: " + idEvent + " is not yours");
        }
        if(location == null){
            return ResponseEntity.badRequest().body("The location with the ID: " + idLocation + " was not found");
        }

        eventLocationService.createEventLocation(eventLocation, event, location);
        return ResponseEntity.ok("Event Location created successfully");
    }

    @GetMapping("/all")
    public List<?> getAll(Authentication authentication){
        String authEmail = authentication.getName();
        Customer customer = customerService.findByEmail(authEmail);
        if(customer instanceof Admin || customer instanceof Manager){
            return eventLocationService.findAll();
        }
        return eventLocationService.findAll2();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id, Authentication authentication){
        String authEmail = authentication.getName();
        Customer customer = customerService.findByEmail(authEmail);
        if(customer instanceof Admin || customer instanceof Manager){
            return new ResponseEntity<>(new EventLocationDTONA(eventLocationService.findById(id)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new EventLocationDTOA(eventLocationService.findById(id)), HttpStatus.OK);
    }

}
