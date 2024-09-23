package com.mindhub.event_planner.services;

import com.mindhub.event_planner.dtos.NotAccesibleForEveryone.ManagerDTO;
import com.mindhub.event_planner.models.Manager;

public interface ManagerService extends GenericService<Manager, ManagerDTO>{
    Manager findById (Long id);
}
