package com.mindhub.event_planner.controllers;

import com.mindhub.event_planner.dtos.EventLocationDTOA;
import com.mindhub.event_planner.dtos.NotAccesibleForEveryone.EventLocationDTONA;
import com.mindhub.event_planner.services.EventLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/eventLocation")
public class EventLocationController {

    @Autowired
    EventLocationService eventLocationService;

    @GetMapping("/authAM/all")
    public List<EventLocationDTONA> getAll(){
        return eventLocationService.findAll();
    }

    @GetMapping("/authU/all")
    public List<EventLocationDTOA> getAll2(){
        return eventLocationService.findAll2();
    }

    @GetMapping("/authAM/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(new EventLocationDTONA(eventLocationService.findById(id)), HttpStatus.OK);
    }

    @GetMapping("/authU/{id}")
    public ResponseEntity<?> getById2(@PathVariable Long id){
        return new ResponseEntity<>(new EventLocationDTOA(eventLocationService.findById(id)), HttpStatus.OK);
    }
}
