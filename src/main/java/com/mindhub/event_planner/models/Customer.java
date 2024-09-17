package com.mindhub.event_planner.models;

import com.mindhub.event_planner.enums.Gender;
import com.mindhub.event_planner.enums.RoleEnum;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_id;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Comment> commentsC = new HashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<LikeStatus> likes = new HashSet<>();

    @OneToMany(mappedBy = "organizer", fetch = FetchType.EAGER)
    private Set<Event> events = new HashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<CustomerEvent> customerEvents = new HashSet<>();

    private String name;

    private String lastName;

    private String email;

    private boolean activated;

    private String password;

    private short age;

    private Gender gender;

    private RoleEnum role;

    public Customer() {}

    public Customer(String name, boolean activated, String lastName, String email, String password, short age, Gender gender, RoleEnum role) {
        this.name = name;
        this.activated = activated;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.role = role;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public Set<Comment> getCommentsC() {
        return commentsC;
    }

    public void addCommentsC(Comment comment) {
        comment.setUser(this);
        commentsC.add(comment);
    }

    public Set<LikeStatus> getLikes() {
        return likes;
    }

    public void addLikes(LikeStatus likeStatus) {
        likeStatus.setUser(this);
        likes.add(likeStatus);
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void addEvents(Event event) {
        event.setOrganizer(this);
        events.add(event);
    }

    public Set<CustomerEvent> getCustomerEvents() {
        return customerEvents;
    }

    public void addCustomerEvents(CustomerEvent customerEvent) {
        customerEvent.setUser(this);
        customerEvents.add(customerEvent);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", commentsC=" + commentsC +
                ", likes=" + likes +
                ", events=" + events +
                ", customerEvents=" + customerEvents +
                ", name=" + name +
                ", lastName=" + lastName +
                ", activated=" + activated +
                ", age=" + age +
                ", gender=" + gender +
                ", role=" + role +
                '}';
    }
}
