package com.mindhub.event_planner.services;

import com.mindhub.event_planner.dtos.create.AdminRegistrationDTO;
import com.mindhub.event_planner.dtos.notAccesibleForEveryone.AdminDTO;
import com.mindhub.event_planner.models.Admin;

public interface AdminService extends GenericService<Admin, AdminDTO>{
    Admin findById(Long id);

    Admin findByEmail(String email);

    void registerAdmin (AdminRegistrationDTO adminRegistrationDTO);
}
