package com.mindhub.event_planner.services;

import com.mindhub.event_planner.dtos.UserDTO;
import com.mindhub.event_planner.models.UserEntity;

public interface UserService extends GenericService<UserEntity, UserDTO>{
    UserEntity findById (Long id);
}
