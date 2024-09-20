package com.mindhub.event_planner.dtos;

import com.mindhub.event_planner.models.CustomerEvent;

public class CustomerEventDTO {

    private Long id;

    public CustomerEventDTO() {}

    public CustomerEventDTO(CustomerEvent customerEvent) {
        this.id = customerEvent.getId();
    }

    public Long getId() {
        return id;
    }
}
