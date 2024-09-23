package com.mindhub.event_planner.services.implement;

import com.mindhub.event_planner.dtos.NotAccesibleForEveryone.ManagerDTO;
import com.mindhub.event_planner.handlers.ObjectNotFound;
import com.mindhub.event_planner.models.Manager;
import com.mindhub.event_planner.repositories.ManagerRepository;
import com.mindhub.event_planner.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManagerServiceImplement implements ManagerService {

    @Autowired
    ManagerRepository managerRepository;

    @Override
    public List<ManagerDTO> findAll() {
        return managerRepository.findAll().stream().map(ManagerDTO::new).collect(Collectors.toList());
    }

    @Override
    public Manager findById(Long id) {
        return managerRepository.findById(id).orElseThrow( () -> new ObjectNotFound("The Manager with the ID:" + id + " was not found"));
    }
}
