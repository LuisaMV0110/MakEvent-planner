package com.mindhub.event_planner.services;

import com.mindhub.event_planner.dtos.notAccesibleForEveryone.CustomerEventDTO;
import com.mindhub.event_planner.models.CustomerEvent;

public interface CustomerEventService extends GenericService<CustomerEvent, CustomerEventDTO>{
    CustomerEvent findById (Long id);
}
