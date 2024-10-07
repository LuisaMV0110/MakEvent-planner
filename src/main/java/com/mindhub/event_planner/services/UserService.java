package com.mindhub.event_planner.services;

import com.mindhub.event_planner.dtos.create.UserManagerRegistrationDTO;
import com.mindhub.event_planner.dtos.notAccesibleForEveryone.UserDTONA;
import com.mindhub.event_planner.models.UserEntity;

public interface UserService extends GenericService<UserEntity, UserDTONA>{
    UserEntity findById (Long id);

    void registerUser(UserManagerRegistrationDTO userRegistrationDTO);

    UserEntity findByEmail(String email);
}
