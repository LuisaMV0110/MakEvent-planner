package com.mindhub.event_planner.services;

import com.mindhub.event_planner.dtos.create.UserManagerRegistrationDTO;
import com.mindhub.event_planner.dtos.notAccesibleForEveryone.ManagerDTONA;
import com.mindhub.event_planner.models.Manager;

public interface ManagerService extends GenericService<Manager, ManagerDTONA>{
    Manager findById (Long id);

    void registerManager(UserManagerRegistrationDTO managerRegistrationDTO);

    Manager findByEmail(String email);
}
