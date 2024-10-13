package com.mindhub.event_planner.controllers;

import com.mindhub.event_planner.dtos.create.UserManagerRegistrationDTO;
import com.mindhub.event_planner.dtos.notAccesibleForEveryone.UserDTONA;
import com.mindhub.event_planner.enums.Gender;
import com.mindhub.event_planner.repositories.CustomerRepository;
import com.mindhub.event_planner.services.CustomerService;
import com.mindhub.event_planner.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;

    @GetMapping("/user/all")
    public List<UserDTONA> getAll(){
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(new UserDTONA(userService.findById(id)), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserManagerRegistrationDTO user){
        if (customerService.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body("Email " + user.getEmail() + " already exists");
        } else if(user.getEmail().isBlank()){
            return ResponseEntity.badRequest().body("Your email is missing");
        } else if (!user.getEmail().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            return ResponseEntity.badRequest().body("Enter a valid Email address");
        }
        if(user.getName().isBlank()){
            return ResponseEntity.badRequest().body("Your name is missing");
        }else if (!user.getName().matches("^[a-zA-Z]*$")) {
            return ResponseEntity.badRequest().body("Enter a valid name. Only letters are allowed");
        }
        if(user.getLastName().isBlank()){
            return ResponseEntity.badRequest().body("Your last name is missing");
        }else if (!user.getLastName().matches("^[a-zA-Z]*$")) {
            return ResponseEntity.badRequest().body("Enter a valid last name. Only letters are allowed");
        }
        if(user.getPassword().isBlank()){
            return ResponseEntity.badRequest().body("Your password is missing");
        }
        if(!user.getGender().equals(Gender.FEMALE) &&!user.getGender().equals(Gender.MALE) && !user.getGender().equals(Gender.OTHER) && !user.getGender().equals(Gender.IPN)){
            return ResponseEntity.badRequest().body("Your gender is missing or the information you are entering is not valid");
        }
        if(user.getAge() < 18){
            return ResponseEntity.badRequest().body("You must be 18 years old or over to register");
        }

        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }
}
