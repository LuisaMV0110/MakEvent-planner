package com.mindhub.event_planner.models;

import jakarta.persistence.*;

@Entity
public class CustomerEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="eventLocation_id")
    private EventLocation eventLocation;

    public CustomerEvent() {}

    public Long getId() {
        return id;
    }

    public UserEntity getUser() { return user; }

    public void setUser(UserEntity user) { this.user = user; }

    public EventLocation getEventLocation() { return eventLocation; }

    public void setEventLocation(EventLocation eventLocation) { this.eventLocation = eventLocation; }

}
