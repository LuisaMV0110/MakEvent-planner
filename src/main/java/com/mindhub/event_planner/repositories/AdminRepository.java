package com.mindhub.event_planner.repositories;

import com.mindhub.event_planner.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
