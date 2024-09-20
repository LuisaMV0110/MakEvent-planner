package com.mindhub.event_planner.services;

import com.mindhub.event_planner.dtos.CustomerDTO;
import com.mindhub.event_planner.models.Customer;

public interface CustomerService extends GenericService<Customer, CustomerDTO>{
    Customer findById (Long id);
}
