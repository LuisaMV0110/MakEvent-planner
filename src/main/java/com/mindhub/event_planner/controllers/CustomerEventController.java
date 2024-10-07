package com.mindhub.event_planner.controllers;

import com.mindhub.event_planner.dtos.notAccesibleForEveryone.CustomerEventDTO;
import com.mindhub.event_planner.services.CustomerEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customerEvent")
public class CustomerEventController {

    @Autowired
    private CustomerEventService customerEventService;

    @GetMapping("/all")
    public List<CustomerEventDTO> getAll(){
        return customerEventService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>( new CustomerEventDTO(customerEventService.findById(id)), HttpStatus.OK);
    }
}
