package com.mindhub.event_planner.services.implement;

import com.mindhub.event_planner.dtos.CustomerEventDTO;
import com.mindhub.event_planner.handlers.ObjectNotFound;
import com.mindhub.event_planner.models.CustomerEvent;
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
        return customerEventRepository.findById(id).orElseThrow( () -> new ObjectNotFound("The CustomerEvent with the ID:" + id + " was not found"));
    }
}
