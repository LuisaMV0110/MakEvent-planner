package com.mindhub.event_planner.dtos;

import com.mindhub.event_planner.models.Location;

import java.util.Set;
import java.util.stream.Collectors;

public class LocationDTO {

    private Long id;

    private String name;

    private String location;

    private int capacity;

    private String img;

    private Set<EventLocationDTO> eventLocations;

    public LocationDTO() {}

    public LocationDTO(Location location) {
        this.id = location.getId();
        this.name = location.getName();
        this.location = location.getLocation();
        this.capacity = location.getCapacity();
        this.img = location.getImg();
        this.eventLocations = location.getEventLocations().stream().map(EventLocationDTO::new).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getImg() {
        return img;
    }

    public Set<EventLocationDTO> getEventLocations() {
        return eventLocations;
    }
}
