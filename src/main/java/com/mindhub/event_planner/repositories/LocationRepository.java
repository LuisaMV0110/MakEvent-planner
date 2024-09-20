package com.mindhub.event_planner.repositories;

import com.mindhub.event_planner.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Location findById (long id);

    Location findByName (String name);

    Location findByLocation (String location);
}
