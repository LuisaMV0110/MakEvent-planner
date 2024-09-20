package com.mindhub.event_planner.repositories;

import com.mindhub.event_planner.models.Event;
import io.micrometer.common.lang.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {

    @NonNull
    Optional<Event> findById (@NonNull UUID id);
}
