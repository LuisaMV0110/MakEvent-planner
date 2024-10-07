package com.mindhub.event_planner.controllers;

import com.mindhub.event_planner.dtos.create.AdminRegistrationDTO;
import com.mindhub.event_planner.dtos.notAccesibleForEveryone.AdminDTO;
import com.mindhub.event_planner.services.AdminService;
import com.mindhub.event_planner.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    CustomerService customerService;

    @GetMapping("/all")
    public List<AdminDTO> getAll(){
        return adminService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(new AdminDTO(adminService.findById(id)), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerAdmin(@RequestBody AdminRegistrationDTO admin){
        if (customerService.existsByEmail(admin.getEmail())) {
            return ResponseEntity.badRequest().body("Email " + admin.getEmail() + " already exists");
        } else if(admin.getEmail().isBlank()){
            return ResponseEntity.badRequest().body("Your email is missing");
        } else if (!admin.getEmail().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            return ResponseEntity.badRequest().body("Enter a valid Email address");
        }

        if(admin.getName().isBlank()){
            return ResponseEntity.badRequest().body("Your name is missing");
        }else if (!admin.getName().matches("^[a-zA-Z]*$")) {
            return ResponseEntity.badRequest().body("Enter a valid name. Only letters are allowed");
        }
        if(admin.getLastName().isBlank()){
            return ResponseEntity.badRequest().body("Your last name is missing");
        }else if (!admin.getLastName().matches("^[a-zA-Z]*$")) {
            return ResponseEntity.badRequest().body("Enter a valid last name. Only letters are allowed");
        }
        if(admin.getPassword().isBlank()){
            return ResponseEntity.badRequest().body("Your password is missing");
        }
        adminService.registerAdmin(admin);
        return ResponseEntity.ok("Admin registered successfully");
    }
}
