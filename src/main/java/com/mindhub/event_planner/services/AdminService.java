package com.mindhub.event_planner.services;

import com.mindhub.event_planner.dtos.AdminDTO;
import com.mindhub.event_planner.models.Admin;

public interface AdminService extends GenericService<Admin, AdminDTO>{
    Admin findById(Long id);
}
