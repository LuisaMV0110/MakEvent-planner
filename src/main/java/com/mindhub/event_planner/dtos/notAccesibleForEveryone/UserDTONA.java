package com.mindhub.event_planner.dtos.notAccesibleForEveryone;

import com.mindhub.event_planner.enums.Gender;
import com.mindhub.event_planner.models.UserEntity;

public class UserDTONA {

    private Long id;

    private String name;

    private String lastName;

    private String email;

    private short age;

    private Gender gender;

    public UserDTONA() {}

    public UserDTONA(UserEntity user) {
        this.id = user.getId();
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.age = user.getAge();
        this.gender = user.getGender();
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

    public short getAge() { return age; }

    public Gender getGender() {
        return gender;
    }
}
