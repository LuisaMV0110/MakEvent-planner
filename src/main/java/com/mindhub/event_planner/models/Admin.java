package com.mindhub.event_planner.models;

import com.mindhub.event_planner.enums.Gender;
import jakarta.persistence.Entity;

@Entity
public class Admin extends Customer{

    public Admin() {
    }

    public Admin(String name, String lastName, String email, String password, boolean activated) {
        super(name, lastName, email, password, activated);
    }
}
