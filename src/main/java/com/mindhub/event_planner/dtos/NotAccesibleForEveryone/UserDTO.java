package com.mindhub.event_planner.dtos.NotAccesibleForEveryone;

import com.mindhub.event_planner.dtos.CommentDTO;
import com.mindhub.event_planner.dtos.LikeDTO;
import com.mindhub.event_planner.enums.Gender;
import com.mindhub.event_planner.models.UserEntity;

import java.util.Set;
import java.util.stream.Collectors;

public class UserDTO {

    private Long id;

    private String name;

    private String lastName;

    private String email;

    private boolean activated;

    private short age;

    private Gender gender;

    private Set<CommentDTO> comments;

    private Set<LikeDTO> likeS;

    private Set<CustomerEventDTO> customerEvents;

    public UserDTO() {}

    public UserDTO(UserEntity user) {
        this.id = user.getId();
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.activated = user.isActivated();
        this.age = user.getAge();
        this.gender = user.getGender();
        this.comments = user.comments.stream().map(CommentDTO::new).collect(Collectors.toSet());
        this.likeS = user.likeS.stream().map(LikeDTO::new).collect(Collectors.toSet());
        this.customerEvents = user.getCustomerEvents().stream().map(CustomerEventDTO::new).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActivated() {
        return activated;
    }

    public short getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Set<CommentDTO> getComments() {
        return comments;
    }

    public Set<LikeDTO> getLikeS() {
        return likeS;
    }

    public Set<CustomerEventDTO> getCustomerEvents() {
        return customerEvents;
    }
}
