package com.mindhub.event_planner.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class CustomerEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userEvent_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private Customer user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="eventLocation_id")
    private EventLocation eventLocation;

    public CustomerEvent() {}

    public Long getUserEvent() {
        return userEvent_id;
    }

    public Customer getUser() {
        return user;
    }

    public void setUser(Customer user) {
        this.user = user;
    }

    public EventLocation getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation_id(EventLocation eventLocation) {
        this.eventLocation = eventLocation;
    }

    @Override
    public String toString() {
        return "CustomerEvent{" +
                "userEvent_id=" + userEvent_id+
                ", user_id=" + user +
                ", eventLocation_id=" + eventLocation +
                '}';
    }
}
