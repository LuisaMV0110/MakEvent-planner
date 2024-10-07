package com.mindhub.event_planner.dtos;

import com.mindhub.event_planner.models.EventLocation;

import java.time.LocalDateTime;

public class EventLocationDTOA {

    private Long id;

    private LocalDateTime date;

    private EventDTOA event;

    private LocationDTO location;

    public EventLocationDTOA() {}

    public EventLocationDTOA(EventLocation eventLocation) {
        this.id = eventLocation.getId();
        this.date = eventLocation.getDate();
        this.event = new EventDTOA(eventLocation.getEvent());
        this.location = new LocationDTO(eventLocation.getLocation());
    }

    public Long getId() { return id; }

    public LocalDateTime getDate() {
        return date;
    }

    public EventDTOA getEvent() { return event; }

    public LocationDTO getLocation() { return location; }
}
