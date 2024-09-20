package com.mindhub.event_planner.dtos;

import com.mindhub.event_planner.models.Event;

import java.util.Set;
import java.util.stream.Collectors;


public class EventDTO {

    private Long id;

    private String desc;

    private String img;

    private short age_req;

    private String name;

    private Set<CommentDTO> comments;

    private Set<LikeDTO> likeS;

    private Set<EventLocationDTO> eventLocations;

    public EventDTO() {}

    public EventDTO(Event event) {
        this.id = event.getId();
        this.name = event.getName();
        this.age_req = event.getAge_req();
        this.img = event.getImg();
        this.desc = event.getDesc();
        this.comments = event.getComments().stream().map(CommentDTO::new).collect(Collectors.toSet());
        this.likeS = event.getLikeS().stream().map(LikeDTO::new).collect(Collectors.toSet());
        this.eventLocations = event.getEventLocations().stream().map(EventLocationDTO::new).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public short getAge_req() {
        return age_req;
    }

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public Set<CommentDTO> getComments() {
        return comments;
    }

    public Set<LikeDTO> getLikeS() {
        return likeS;
    }

    public Set<EventLocationDTO> getEventLocations() {
        return eventLocations;
    }

}
