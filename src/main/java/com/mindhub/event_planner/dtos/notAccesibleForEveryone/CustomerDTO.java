package com.mindhub.event_planner.dtos.notAccesibleForEveryone;

import com.mindhub.event_planner.enums.Gender;
import com.mindhub.event_planner.models.Customer;

public class CustomerDTO {

    private Long id;

    private String name;

    private String lastName;

    private String email;

    private short age;

    private Gender gender;

    public CustomerDTO() {}

    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.lastName = customer.getLastName();
        this.email = customer.getEmail();
        this.age = customer.getAge();
        this.gender = customer.getGender();
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

    public short getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }
}
