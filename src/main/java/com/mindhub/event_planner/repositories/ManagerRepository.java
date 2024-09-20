package com.mindhub.event_planner.repositories;

import com.mindhub.event_planner.models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

    Manager findById(long id);

    Manager findByEmail(String email);
}