package com.mindhub.event_planner.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long location_id;

    @OneToMany(mappedBy = "location", fetch = FetchType.EAGER)
    private Set<EventLocation> eventLocations = new HashSet<>();

    private String name;

    private String location;

    private int capacity;

    private String img;

    public Location() {}

    public Location(String name, String location, int capacity, String img) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.img = img;
    }

    public Long getLocation_id() {
        return location_id;
    }

    public Set<EventLocation> getEventLocations() {
        return eventLocations;
    }

    public void addEventLocations(EventLocation eventLocation) {
        eventLocation.setLocation(this);
        eventLocations.add(eventLocation);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Location{" +
                "location_id=" + location_id +
                ", eventLocations=" + eventLocations +
                ", name=" + name +
                ", location=" + location +
                ", capacity=" + capacity +
                ", img=" + img +
                '}';
    }
}
