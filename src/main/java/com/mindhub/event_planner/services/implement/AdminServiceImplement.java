package com.mindhub.event_planner.services.implement;

import com.mindhub.event_planner.dtos.NotAccesibleForEveryone.AdminDTO;
import com.mindhub.event_planner.handlers.ObjectNotFound;
import com.mindhub.event_planner.models.Admin;
import com.mindhub.event_planner.repositories.AdminRepository;
import com.mindhub.event_planner.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImplement implements AdminService{

    @Autowired
    AdminRepository adminRepository;

    @Override
    public List<AdminDTO> findAll() {
        return adminRepository.findAll().stream().map(AdminDTO::new).collect(Collectors.toList());
    }

    @Override
    public Admin findById(Long id) {
        return adminRepository.findById(id).orElseThrow( () -> new ObjectNotFound("The Admin with the ID:" + id + " was not found"));
    }
}
