package com.mindhub.event_planner.services.implement;

import com.mindhub.event_planner.dtos.notAccesibleForEveryone.CustomerEventDTO;
import com.mindhub.event_planner.handlers.ObjectNotFound;
import com.mindhub.event_planner.models.CustomerEvent;
import com.mindhub.event_planner.models.EventLocation;
import com.mindhub.event_planner.models.UserEntity;
import com.mindhub.event_planner.repositories.CustomerEventRepository;
import com.mindhub.event_planner.services.CustomerEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerEventServiceImplement implements CustomerEventService {

    @Autowired
    CustomerEventRepository customerEventRepository;

    @Override
    public List<CustomerEventDTO> findAll() {
        return customerEventRepository.findAll().stream().map(CustomerEventDTO::new).collect(Collectors.toList());
    }

    @Override
    public CustomerEvent findById(Long id) {
        return customerEventRepository.findById(id).orElseThrow( () -> new ObjectNotFound("The customer event with the ID: " + id + " was not found"));
    }

    @Override
    public void createCustomerEvent(UserEntity user, EventLocation eventLocation) {
        CustomerEvent customerEvent = new CustomerEvent(
                user,
                eventLocation
        );
        customerEventRepository.save(customerEvent);
    }
}
