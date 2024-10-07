package com.mindhub.event_planner.dtos.notAccesibleForEveryone;

import com.mindhub.event_planner.models.Event;


public class EventDTONA {

    private Long id;

    private String desc;

    private String img;

    private short age_req;

    private String name;

    private ManagerDTONA manager;

    public EventDTONA() {}

    public EventDTONA(Event event) {
        this.id = event.getId();
        this.name = event.getName();
        this.age_req = event.getAge_req();
        this.img = event.getImg();
        this.desc = event.getDesc();
        this.manager = new ManagerDTONA(event.getManager());
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

    public ManagerDTONA getManager() { return manager; }

}
