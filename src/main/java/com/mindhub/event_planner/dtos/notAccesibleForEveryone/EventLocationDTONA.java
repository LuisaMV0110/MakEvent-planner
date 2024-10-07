package com.mindhub.event_planner.dtos.notAccesibleForEveryone;

import com.mindhub.event_planner.dtos.LocationDTO;
import com.mindhub.event_planner.models.EventLocation;

import java.time.LocalDateTime;

public class EventLocationDTONA {

    private Long id;

    private LocalDateTime date;

    private  int assistance;

    private EventDTONA event;

    private LocationDTO location;

    public EventLocationDTONA() {}

    public EventLocationDTONA(EventLocation eventLocation) {
        this.id = eventLocation.getId();
        this.date = eventLocation.getDate();
        this.assistance = eventLocation.getAssistance();
        this.event = new EventDTONA(eventLocation.getEvent());
        this.location = new LocationDTO(eventLocation.getLocation());
    }

    public Long getId() { return id; }

    public LocalDateTime getDate() {
        return date;
    }

    public int getAssistance() {
        return assistance;
    }

    public EventDTONA getEvent() { return event; }

    public LocationDTO getLocation() { return location; }
}
