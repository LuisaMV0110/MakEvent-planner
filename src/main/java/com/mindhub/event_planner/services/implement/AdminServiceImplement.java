package com.mindhub.event_planner.services.implement;

import com.mindhub.event_planner.dtos.create.AdminRegistrationDTO;
import com.mindhub.event_planner.dtos.notAccesibleForEveryone.AdminDTO;
import com.mindhub.event_planner.handlers.ObjectNotFound;
import com.mindhub.event_planner.models.Admin;
import com.mindhub.event_planner.models.Manager;
import com.mindhub.event_planner.repositories.AdminRepository;
import com.mindhub.event_planner.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImplement implements AdminService{

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<AdminDTO> findAll() {
        return adminRepository.findAll().stream().map(AdminDTO::new).collect(Collectors.toList());
    }

    @Override
    public Admin findById(Long id) {
        return adminRepository.findById(id).orElseThrow( () -> new ObjectNotFound("The admin with the ID: " + id + " was not found"));
    }

    @Override
    public Admin findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    @Override
    public void registerAdmin(AdminRegistrationDTO adminRegistrationDTO) {
        Admin admin = new Admin();
        admin.setName(adminRegistrationDTO.getName());
        admin.setLastName(adminRegistrationDTO.getLastName());
        admin.setEmail(adminRegistrationDTO.getEmail());
        admin.setPassword(passwordEncoder.encode(adminRegistrationDTO.getPassword()));
        admin.setActivated(true);
        adminRepository.save(admin);
    }
}
