package com.mindhub.event_planner.repositories;

import com.mindhub.event_planner.models.CustomerEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerEventRepository extends JpaRepository<CustomerEvent, Long> {

    CustomerEvent findById (long id);
}
