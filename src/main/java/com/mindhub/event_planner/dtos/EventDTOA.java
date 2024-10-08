package com.mindhub.event_planner.dtos;

import com.mindhub.event_planner.models.Event;

import java.util.Set;

public class EventDTOA {


    private Long id;

    private String desc;

    private String img;

    private short age_req;

    private String name;

    private ManagerDTOA manager;


    private Set<CommentDTOA> comments;

    private Set<LikeDTOA> likeS;


    public EventDTOA() {}

    public EventDTOA(Event event) {
        this.id = event.getId();
        this.name = event.getName();
        this.age_req = event.getAge_req();
        this.img = event.getImg();
        this.desc = event.getDesc();
        this.manager = new ManagerDTOA(event.getManager());
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

    public ManagerDTOA getManager() {
        return manager;
    }
}
