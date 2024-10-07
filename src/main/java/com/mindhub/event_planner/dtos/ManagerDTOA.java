package com.mindhub.event_planner.dtos;

import com.mindhub.event_planner.models.Manager;

public class ManagerDTOA {

    private Long id;

    private String name;

    private String lastName;

    private String email;

    public ManagerDTOA() {}

    public ManagerDTOA(Manager manager) {
        this.id = manager.getId();
        this.name = manager.getName();
        this.lastName = manager.getLastName();
        this.email = manager.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

}
