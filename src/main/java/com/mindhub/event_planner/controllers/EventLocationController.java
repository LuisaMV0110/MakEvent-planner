package com.mindhub.event_planner.controllers;

import com.mindhub.event_planner.dtos.EventLocationDTOA;
import com.mindhub.event_planner.dtos.notAccesibleForEveryone.EventLocationDTONA;
import com.mindhub.event_planner.models.Admin;
import com.mindhub.event_planner.models.Customer;
import com.mindhub.event_planner.models.Manager;
import com.mindhub.event_planner.services.CustomerService;
import com.mindhub.event_planner.services.EventLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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

    @Autowired
    CustomerService customerService;

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
