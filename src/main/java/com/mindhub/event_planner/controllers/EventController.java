package com.mindhub.event_planner.controllers;

import com.mindhub.event_planner.dtos.EventDTOA;
import com.mindhub.event_planner.dtos.NotAccesibleForEveryone.EventDTONA;
import com.mindhub.event_planner.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/authAM/all")
    public List<EventDTONA> getAll(){
        return eventService.findAll();
    }

    @GetMapping("/authU/all")
    public List<EventDTOA> getAll2(){
        return eventService.findAll2();
    }

    @GetMapping("/authAM/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(new EventDTONA(eventService.findById(id)), HttpStatus.OK);
    }

    @GetMapping("/authU/{id}")
    public ResponseEntity<?> getById2(@PathVariable Long id){
        return new ResponseEntity<>(new EventDTOA(eventService.findById(id)), HttpStatus.OK);
    }





}
