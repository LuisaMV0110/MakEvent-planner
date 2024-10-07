package com.mindhub.event_planner.services;

import com.mindhub.event_planner.dtos.notAccesibleForEveryone.CustomerDTO;
import com.mindhub.event_planner.models.Customer;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface CustomerService extends GenericService<Customer, CustomerDTO>{
    Customer findById (Long id);

    Customer findByEmail (String email);

    boolean existsByEmail(String email);

}
