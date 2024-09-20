package com.mindhub.event_planner.services.implement;

import com.mindhub.event_planner.dtos.UserDTO;
import com.mindhub.event_planner.handlers.ObjectNotFound;
import com.mindhub.event_planner.models.UserEntity;
import com.mindhub.event_planner.repositories.UserRepository;
import com.mindhub.event_planner.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplement implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElseThrow( () -> new ObjectNotFound("The User with the ID:" + id + " was not found"));
    }
}
