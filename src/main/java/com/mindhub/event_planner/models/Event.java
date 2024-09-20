package com.mindhub.event_planner.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="manager_id")
    private Manager manager;

    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER)
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER)
    private Set<LikeStatus> likeS = new HashSet<>();

    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER)
    private Set<EventLocation> eventLocations = new HashSet<>();

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

    public Long getId() { return id; }

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

    public Manager getManager() { return manager; }

    public void setManager(Manager manager) { this.manager = manager; }

    public Set<Comment> getComments() { return comments; }

    public void addComments(Comment comment) {
        comment.setEvent(this);
        comments.add(comment);
    }

    public Set<LikeStatus> getLikeS() { return likeS; }

    public void addLikeS(LikeStatus likeStatus) {
        likeStatus.setEvent(this);
        likeS.add(likeStatus);
    }

    public Set<EventLocation> getEventLocations() { return eventLocations; }

    public void addEventLocations(EventLocation eventLocation) {
        eventLocation.setEvent(this);
        eventLocations.add(eventLocation);
    }
}
