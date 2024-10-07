package com.mindhub.event_planner.controllers;

import com.mindhub.event_planner.dtos.EventDTOA;
import com.mindhub.event_planner.dtos.notAccesibleForEveryone.EventDTONA;
import com.mindhub.event_planner.models.*;
import com.mindhub.event_planner.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ManagerService managerService;

    @PostMapping("/auth/create")
    public ResponseEntity<String> createEvent(@RequestBody Event event, Authentication authentication){
        Manager manager = managerService.findByEmail(authentication.getName());

        if(event.getName().isBlank()){
            return ResponseEntity.badRequest().body("The name of the event is missing");
        }
        if(event.getDesc().isBlank()){
            return ResponseEntity.badRequest().body("The description of the event is missing");
        }
        if(event.getImg().isBlank()){
            return ResponseEntity.badRequest().body("The image of the event is missing");
        }
        if(event.getAge_req() < 0){
            return ResponseEntity.badRequest().body("The required age for the event is missing");
        }

        eventService.createEvent(event, manager);
        return ResponseEntity.ok("Event created successfully");
    }

    @GetMapping("/auth/all")
    public List<EventDTONA> getAll(Authentication authentication){
        Customer customer = customerService.findByEmail(authentication.getName());
        if (customer instanceof Manager){
            return ((Manager) customer).getEvents().stream().map(EventDTONA::new).collect(Collectors.toList());
        }
            return eventService.findAll();
    }

    @GetMapping("/auth/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id, Authentication authentication){
        Customer customer = customerService.findByEmail(authentication.getName());
        Event event = eventService.findById(id);
        if ((event != null && event.getManager() == customer) || customer instanceof Admin){
            return new ResponseEntity<>(new EventDTONA(eventService.findById(id)), HttpStatus.OK);
        } else if(event != null && event.getManager() != customer) {
            return new ResponseEntity<>(new EventDTOA(eventService.findById(id)), HttpStatus.OK);
        }
        return new ResponseEntity<>("An error occurred finding the event with ID: " + id, HttpStatus.FORBIDDEN);
    }

    @GetMapping("/public/all")
    public List<EventDTOA> getAll2(){ return eventService.findAll2();}

    @GetMapping("/public/{id}")
    public ResponseEntity<?> getById2(@PathVariable Long id){
        return new ResponseEntity<>(new EventDTOA(eventService.findById(id)), HttpStatus.OK);
    }

}
