package com.mindhub.event_planner.dtos;

import com.mindhub.event_planner.models.Location;

public class LocationDTO {

    private Long id;

    private String name;

    private String location;

    private int capacity;

    private String img;

    public LocationDTO() {}

    public LocationDTO(Location location) {
        this.id = location.getId();
        this.name = location.getName();
        this.location = location.getLocation();
        this.capacity = location.getCapacity();
        this.img = location.getImg();
    }

    public Long getId() { return id; }

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
}
