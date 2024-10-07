package com.mindhub.event_planner.services.implement;

import com.mindhub.event_planner.dtos.notAccesibleForEveryone.CustomerDTO;
import com.mindhub.event_planner.handlers.ObjectNotFound;
import com.mindhub.event_planner.models.Customer;
import com.mindhub.event_planner.repositories.CustomerRepository;
import com.mindhub.event_planner.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImplement implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow( () -> new ObjectNotFound("The Customer with the ID:" + id + " was not found"));
    }

    @Override
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email).orElseThrow( () -> new ObjectNotFound("The customer with the ID: " + email + " was not found"));
    }

    @Override
    public boolean existsByEmail(String email) {
        return customerRepository.existsByEmail(email);
    }

    @Override
    public List<CustomerDTO> findAll() {
        return customerRepository.findAll().stream().map(CustomerDTO::new).collect(Collectors.toList());
    }
}
