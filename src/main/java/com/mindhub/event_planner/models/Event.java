package com.mindhub.event_planner.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long event_id;

    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER)
    private Set<Comment> commentsE = new HashSet<>();

    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER)
    private Set<LikeStatus> likeStatuses = new HashSet<>();

    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER)
    private Set<EventLocation> eventLocations = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="organizer_id")
    private Customer organizer;

    private String desc;

    private String img;

    private short age_req;

    private String name;

    public Event() {}

    public Event(String desc, String img, short age_req, String name) {
        this.desc = desc;
        this.img = img;
        this.age_req = age_req;
        this.name = name;
    }

    public Long getEvent_id() {
        return event_id;
    }

    public Set<Comment> getComments() {
        return commentsE;
    }

    public void addComments(Comment comment) {
        comment.setEvent(this);
        commentsE.add(comment);
    }

    public Set<LikeStatus> getLikes() {
        return likeStatuses;
    }

    public void addLikes(LikeStatus likeStatus) {
        likeStatus.setEvent(this);
        likeStatuses.add(likeStatus);
    }

    public Set<EventLocation> getEventLocations() {
        return eventLocations;
    }

    public void addEventLocations(EventLocation eventLocation) {
        eventLocation.setEvent(this);
        eventLocations.add(eventLocation);
    }

    public Customer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Customer organizer) {
        this.organizer = organizer;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public short getAge_req() {
        return age_req;
    }

    public void setAge_req(short age_req) {
        this.age_req = age_req;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Event{" +
                "event_id=" + event_id +
                ", comments=" + commentsE +
                ", likes=" + likeStatuses +
                ", eventLocations=" + eventLocations +
                ", organizer=" + organizer +
                ", desc=" + desc +
                ", img=" + img +
                ", age_req=" + age_req +
                ", name=" + name +
                '}';
    }
}
