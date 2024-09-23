package com.mindhub.event_planner.controllers;

import com.mindhub.event_planner.dtos.NotAccesibleForEveryone.ManagerDTO;
import com.mindhub.event_planner.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/manager")
public class ManagerController {

    @Autowired
    ManagerService managerService;

    @GetMapping("/all")
    public List<ManagerDTO> getAll(){
        return managerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(new ManagerDTO(managerService.findById(id)), HttpStatus.OK);
    }
}
