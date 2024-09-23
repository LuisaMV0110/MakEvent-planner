package com.mindhub.event_planner.controllers;

import com.mindhub.event_planner.dtos.NotAccesibleForEveryone.AdminDTO;
import com.mindhub.event_planner.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public List<AdminDTO> getAll(){
        return adminService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(new AdminDTO(adminService.findById(id)), HttpStatus.OK);
    }
}
