package com.mindhub.event_planner.dtos.notAccesibleForEveryone;

import com.mindhub.event_planner.models.CustomerEvent;

public class CustomerEventDTO {

    private Long id;

    private UserDTONA user;

    private EventLocationDTONA eventLocation;

    public CustomerEventDTO() {}

    public CustomerEventDTO(CustomerEvent customerEvent) {
        this.id = customerEvent.getId();
        this.user = new UserDTONA(customerEvent.getUser());
        this.eventLocation = new EventLocationDTONA(customerEvent.getEventLocation());
    }

    public Long getId() {
        return id;
    }

    public UserDTONA getUser() { return user; }

    public EventLocationDTONA getEventLocation() { return eventLocation; }
}
