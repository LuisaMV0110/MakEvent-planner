package com.mindhub.event_planner.services.implement;

import com.mindhub.event_planner.dtos.create.UserManagerRegistrationDTO;
import com.mindhub.event_planner.dtos.notAccesibleForEveryone.UserDTONA;
import com.mindhub.event_planner.enums.Gender;
import com.mindhub.event_planner.handlers.ObjectNotFound;
import com.mindhub.event_planner.models.UserEntity;
import com.mindhub.event_planner.repositories.CustomerRepository;
import com.mindhub.event_planner.repositories.UserRepository;
import com.mindhub.event_planner.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplement implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTONA> findAll() {
        return userRepository.findAll().stream().map(UserDTONA::new).collect(Collectors.toList());
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFound("The user with the ID: " + id + " was not found"));
    }

    @Override
    public void registerUser(UserManagerRegistrationDTO userRegistrationDTO) {
        UserEntity user = new UserEntity();
        user.setName(userRegistrationDTO.getName());
        user.setLastName(userRegistrationDTO.getLastName());
        user.setEmail(userRegistrationDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
        user.setGender(userRegistrationDTO.getGender());
        user.setAge(userRegistrationDTO.getAge());
        user.setActivated(false);
        userRepository.save(user);
}

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
