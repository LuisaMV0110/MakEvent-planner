package com.mindhub.event_planner.dtos.NotAccesibleForEveryone;

import com.mindhub.event_planner.enums.Gender;
import com.mindhub.event_planner.models.Manager;

import java.util.Set;
import java.util.stream.Collectors;

public class ManagerDTO {

    private Long id;

    private String name;

    private String lastName;

    private String email;

    private boolean activated;

    private short age;

    private Gender gender;

    private Set<EventDTONA> events;

    public ManagerDTO() {}

    public ManagerDTO(Manager manager) {
        this.id = manager.getId();
        this.name = manager.getName();
        this.lastName = manager.getLastName();
        this.email = manager.getEmail();
        this.activated = manager.isActivated();;
        this.age = manager.getAge();
        this.gender = manager.getGender();
        this.events = manager.getEvents().stream().map(EventDTONA::new).collect(Collectors.toSet());
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

    public short getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Set<EventDTONA> getEvents() {
        return events;
    }
}
