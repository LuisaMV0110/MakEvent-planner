package com.mindhub.event_planner.repositories;

import com.mindhub.event_planner.models.EventLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventLocationRepository extends JpaRepository<EventLocation, Long> {

    EventLocation findById (long id);
}
