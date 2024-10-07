package com.mindhub.event_planner.dtos;

import com.mindhub.event_planner.models.UserEntity;

public class UserDTOA {

    private Long id;

    private String name;

    private String lastName;

    public UserDTOA() {}

    public UserDTOA(UserEntity user) {
        this.id = user.getId();
        this.name = user.getName();
        this.lastName = user.getLastName();
    }

    public Long getId() { return id; }

    public String getName() { return name; }

    public String getLastName() { return lastName; }
}
