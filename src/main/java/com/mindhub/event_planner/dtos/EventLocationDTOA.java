package com.mindhub.event_planner.dtos;

import com.mindhub.event_planner.models.EventLocation;

import java.time.LocalDateTime;

public class EventLocationDTOA {

    private Long id;

    private LocalDateTime date;

    public EventLocationDTOA() {}

    public EventLocationDTOA(EventLocation eventLocation) {
        this.id = eventLocation.getId();
        this.date = eventLocation.getDate();
    }

    public Long getId() { return id; }

    public LocalDateTime getDate() {
        return date;
    }

}
