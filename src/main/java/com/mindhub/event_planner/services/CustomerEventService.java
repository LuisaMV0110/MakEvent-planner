package com.mindhub.event_planner.services;

import com.mindhub.event_planner.dtos.notAccesibleForEveryone.CustomerEventDTO;
import com.mindhub.event_planner.models.CustomerEvent;
import com.mindhub.event_planner.models.EventLocation;
import com.mindhub.event_planner.models.UserEntity;

public interface CustomerEventService extends GenericService<CustomerEvent, CustomerEventDTO>{
    CustomerEvent findById (Long id);

    void createCustomerEvent (UserEntity user, EventLocation eventLocation);
}
