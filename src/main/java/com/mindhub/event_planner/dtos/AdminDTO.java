package com.mindhub.event_planner.dtos;

import com.mindhub.event_planner.models.Admin;

public class AdminDTO {

    private Long id;

    private String name;

    private String lastName;

    private String email;

    private boolean activated;


    public AdminDTO() {}

    public AdminDTO(Admin admin) {
        this.id = admin.getId();
        this.name = admin.getName();
        this.lastName = admin.getLastName();
        this.email = admin.getEmail();
        this.activated = admin.isActivated();
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

    public boolean isActivated() {
        return activated;
    }
}
