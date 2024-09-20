package com.mindhub.event_planner.dtos;

import com.mindhub.event_planner.models.CustomerEvent;
import com.mindhub.event_planner.models.EventLocation;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class EventLocationDTO {

    private Long id;

    private LocalDateTime date;

    private  int assistance;

    private Set<CustomerEventDTO> customerEvents;

    public EventLocationDTO() {}

    public EventLocationDTO(EventLocation eventLocation) {
        this.id = eventLocation.getId();
        this.date = eventLocation.getDate();
        this.assistance = eventLocation.getAssistance();
        this.customerEvents = eventLocation.getCustomerEvents().stream().map(CustomerEventDTO::new).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getAssistance() {
        return assistance;
    }

    public Set<CustomerEventDTO> getCustomerEvents() {
        return customerEvents;
    }
}
