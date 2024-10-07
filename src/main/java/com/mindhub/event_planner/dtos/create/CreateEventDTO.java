package com.mindhub.event_planner.dtos.create;

public class CreateEventDTO {

    private String desc;

    private String img;

    private short age_req;

    private String name;

    public String getDesc() { return desc; }

    public void setDesc(String desc) { this.desc = desc; }

    public String getImg() { return img; }

    public void setImg(String img) { this.img = img; }

    public short getAge_req() { return age_req; }

    public void setAge_req(short age_req) { this.age_req = age_req; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
