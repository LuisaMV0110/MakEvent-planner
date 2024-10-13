package com.mindhub.event_planner.controllers;

import com.mindhub.event_planner.dtos.notAccesibleForEveryone.CustomerEventDTO;
import com.mindhub.event_planner.models.Customer;
import com.mindhub.event_planner.models.CustomerEvent;
import com.mindhub.event_planner.models.EventLocation;
import com.mindhub.event_planner.models.UserEntity;
import com.mindhub.event_planner.services.CustomerEventService;
import com.mindhub.event_planner.services.CustomerService;
import com.mindhub.event_planner.services.EventLocationService;
import com.mindhub.event_planner.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customerEvent")
public class CustomerEventController {

    @Autowired
    private CustomerEventService customerEventService;

    @Autowired
    private UserService userService;
    @Autowired
    private EventLocationService eventLocationService;

    @PostMapping("/auth/create")
    public ResponseEntity<String> createCustomerEvent(@RequestParam Long idEventLocation, Authentication authentication){
        UserEntity user = userService.findByEmail(authentication.getName());
        EventLocation eventLocation = eventLocationService.findById(idEventLocation);
        List <CustomerEvent> customerEventE = user.getCustomerEvents().stream().toList();
        Optional<CustomerEvent> result = customerEventE.stream().filter(customerEvent -> customerEvent.getEventLocation() == eventLocation).findFirst();

        if (eventLocation == null){
            return ResponseEntity.badRequest().body("The event with the ID: " + idEventLocation + " was not found");
        }
        if(eventLocation.getEvent().getAge_req() > user.getAge()){
            return ResponseEntity.badRequest().body("You do not meet the minimum age requirement for this event");
        }
        if(eventLocation.getAssistance() <= 0){
            return ResponseEntity.badRequest().body("This event is sold out");
        }
        if(result.isPresent()){
            return ResponseEntity.badRequest().body("You have already registered for this event.");
        }

        eventLocation.setAssistance(eventLocation.getAssistance() - 1);
        customerEventService.createCustomerEvent(user, eventLocation);
        return ResponseEntity.ok("You have successfully registered for this event");
    }

    @GetMapping("/all")
    public List<CustomerEventDTO> getAll(){
        return customerEventService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>( new CustomerEventDTO(customerEventService.findById(id)), HttpStatus.OK);
    }
}
