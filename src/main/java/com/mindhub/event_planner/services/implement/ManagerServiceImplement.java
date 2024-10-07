package com.mindhub.event_planner.services.implement;

import com.mindhub.event_planner.dtos.create.UserManagerRegistrationDTO;
import com.mindhub.event_planner.dtos.notAccesibleForEveryone.ManagerDTONA;
import com.mindhub.event_planner.enums.Gender;
import com.mindhub.event_planner.handlers.ObjectNotFound;
import com.mindhub.event_planner.models.Customer;
import com.mindhub.event_planner.models.Manager;
import com.mindhub.event_planner.models.UserEntity;
import com.mindhub.event_planner.repositories.ManagerRepository;
import com.mindhub.event_planner.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManagerServiceImplement implements ManagerService {

    @Autowired
    ManagerRepository managerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<ManagerDTONA> findAll() {
        return managerRepository.findAll().stream().map(ManagerDTONA::new).collect(Collectors.toList());
    }

    @Override
    public Manager findById(Long id) {
        return managerRepository.findById(id).orElseThrow( () -> new ObjectNotFound("The manager with the ID: " + id + " was not found"));
    }

    @Override
    public void registerManager(UserManagerRegistrationDTO managerRegistrationDTO) {
        Manager manager = new Manager();
        manager.setName(managerRegistrationDTO.getName());
        manager.setLastName(managerRegistrationDTO.getLastName());
        manager.setEmail(managerRegistrationDTO.getEmail());
        manager.setPassword(passwordEncoder.encode(managerRegistrationDTO.getPassword()));
        manager.setGender(managerRegistrationDTO.getGender());
        manager.setAge(managerRegistrationDTO.getAge());
        manager.setActivated(false);
        managerRepository.save(manager);
    }

    @Override
    public Manager findByEmail(String email) {
        return managerRepository.findByEmail(email);
    }
}
