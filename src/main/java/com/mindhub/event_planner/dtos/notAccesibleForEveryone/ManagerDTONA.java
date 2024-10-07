package com.mindhub.event_planner.dtos.notAccesibleForEveryone;

import com.mindhub.event_planner.enums.Gender;
import com.mindhub.event_planner.models.Manager;
public class ManagerDTONA {

    private Long id;

    private String name;

    private String lastName;

    private String email;

    private short age;

    private Gender gender;

    public ManagerDTONA() {}

    public ManagerDTONA(Manager manager) {
        this.id = manager.getId();
        this.name = manager.getName();
        this.lastName = manager.getLastName();
        this.email = manager.getEmail();
        this.age = manager.getAge();
        this.gender = manager.getGender();
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

    public short getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }
}
