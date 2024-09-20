package com.mindhub.event_planner.models;

import com.mindhub.event_planner.enums.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class UserEntity extends Customer{

    public UserEntity() {}

    @OneToMany(mappedBy = "user")
    public Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "user")
    public Set<LikeStatus> likeS = new HashSet<>();

    @OneToMany(mappedBy = "user")
    public Set<CustomerEvent> customerEvents = new HashSet<>();


    public UserEntity(String name, boolean activated, String lastName, String email, String password, short age, Gender gender) {
        super(name, activated, lastName, email, password, age, gender);
    }

    public Set<Comment> getComments() { return comments; }

    public void addComments(Comment comment) {
        comment.setUser(this);
        comments.add(comment);
    }

    public Set<LikeStatus> getLikeS() { return likeS; }

    public void addLikeS(LikeStatus like) {
        like.setUser(this);
        likeS.add(like);
    }

    public Set<CustomerEvent> getCustomerEvents() { return customerEvents; }

    public void addCustomerEvents(CustomerEvent customerEvent) {
        customerEvent.setUser(this);
        customerEvents.add(customerEvent);
    }
}
