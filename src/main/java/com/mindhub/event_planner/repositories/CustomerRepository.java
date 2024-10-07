package com.mindhub.event_planner.repositories;

import com.mindhub.event_planner.models.Customer;
import com.mindhub.event_planner.models.CustomerEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findById (long id);

    Optional<Customer> findByEmail(String email);

    boolean existsByEmail(String email);

}
