package com.mindhub.event_planner.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class EventLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "eventLocation", fetch = FetchType.EAGER)
    private Set<CustomerEvent> customerEvents = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="event_id")
    private Event event;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="location_id")
    private Location location;

    private LocalDateTime date;

    private  int assistance;

    public EventLocation() {
    }

    public EventLocation( LocalDateTime date, int assistance) {
        this.date = date;
        this.assistance = assistance;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getAssistance() {
        return assistance;
    }

    public void setAssistance(int assistance) {
        this.assistance = assistance;
    }

    public Event getEvent() { return event; }

    public void setEvent(Event event) { this.event = event; }

    public Location getLocation() { return location; }

    public void setLocation(Location location) { this.location = location;}

    public Set<CustomerEvent> getCustomerEvents() { return customerEvents; }

    public void addCustomerEvents(CustomerEvent customerEvent) {
        customerEvent.setEventLocation(this);
        customerEvents.add(customerEvent);
    }
}
