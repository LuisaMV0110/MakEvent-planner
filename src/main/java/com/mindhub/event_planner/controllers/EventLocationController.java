package com.mindhub.event_planner.controllers;

import com.mindhub.event_planner.dtos.EventLocationDTO;
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

    @GetMapping("/all")
    public List<EventLocationDTO> getAll(){
        return eventLocationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(new EventLocationDTO(eventLocationService.findById(id)), HttpStatus.OK);
    }
}
