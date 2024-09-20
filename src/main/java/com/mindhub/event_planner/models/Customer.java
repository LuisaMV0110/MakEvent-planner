package com.mindhub.event_planner.models;

import com.mindhub.event_planner.enums.Gender;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    private String email;

    private boolean activated;

    private String password;

    private short age;

    private Gender gender;

    public Customer() {}

    public Customer(String name, String lastName, String email, String password, boolean activated) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.activated = activated;
    }

    public Customer(String name, boolean activated, String lastName, String email, String password, short age, Gender gender) {
        this.name = name;
        this.activated = activated;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.gender = gender;
    }

    public Long getId() { return id;}

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public boolean isActivated() { return activated; }

    public void setActivated(boolean activated) { this.activated = activated; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public short getAge() { return age; }

    public void setAge(short age) { this.age = age; }

    public Gender getGender() { return gender; }

    public void setGender(Gender gender) { this.gender = gender; }

}
