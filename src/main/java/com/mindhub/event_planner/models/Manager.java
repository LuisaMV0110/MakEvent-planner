package com.mindhub.event_planner.models;

import com.mindhub.event_planner.enums.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Manager extends Customer{

    @OneToMany(mappedBy = "manager")
    public Set<Event> events = new HashSet<>();

    public Manager() {}

    public Manager(String name, boolean activated, String lastName, String email, String password, short age, Gender gender) {
        super(name, activated, lastName, email, password, age, gender);
    }

    public Set<Event> getEvents() { return events; }

    public void addEvents(Event event) {
        event.setManager(this);
        events.add(event);
    }

}
