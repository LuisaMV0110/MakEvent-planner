package com.mindhub.event_planner.controllers;

import com.mindhub.event_planner.dtos.create.UserManagerRegistrationDTO;
import com.mindhub.event_planner.dtos.notAccesibleForEveryone.ManagerDTONA;
import com.mindhub.event_planner.enums.Gender;
import com.mindhub.event_planner.services.CustomerService;
import com.mindhub.event_planner.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manager")
public class ManagerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ManagerService managerService;

    @GetMapping("/all")
    public List<ManagerDTONA> getAll(){
        return managerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(new ManagerDTONA(managerService.findById(id)), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerManager(@RequestBody UserManagerRegistrationDTO manager){
        if (customerService.existsByEmail(manager.getEmail())) {
            return ResponseEntity.badRequest().body("Email " + manager.getEmail() + " already exists");
        } else if(manager.getEmail().isBlank()){
            return ResponseEntity.badRequest().body("The email is missing");
        } else if (!manager.getEmail().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            return ResponseEntity.badRequest().body("Enter a valid Email address");
        }
        if(manager.getName().isBlank()){
            return ResponseEntity.badRequest().body("The name is missing");
        }else if (!manager.getName().matches("^[a-zA-Z]*$")) {
            return ResponseEntity.badRequest().body("Enter a valid name. Only letters are allowed");
        }
        if(manager.getLastName().isBlank()){
            return ResponseEntity.badRequest().body("The last name is missing");
        }else if (!manager.getLastName().matches("^[a-zA-Z]*$")) {
            return ResponseEntity.badRequest().body("Enter a valid last name. Only letters are allowed");
        }
        if(manager.getPassword().isBlank()){
            return ResponseEntity.badRequest().body("The  password is missing");
        }
        if(!manager.getGender().equals(Gender.FEMALE) &&!manager.getGender().equals(Gender.MALE) && !manager.getGender().equals(Gender.OTHER) && !manager.getGender().equals(Gender.IPN)){
            return ResponseEntity.badRequest().body("The gender is missing or the information you are entering is not valid");
        }
        if(manager.getAge() < 18){
            return ResponseEntity.badRequest().body("The must be 18 years old or over to register");
        }
        managerService.registerManager(manager);
        return ResponseEntity.ok("Manager registered successfully");
    }
}
