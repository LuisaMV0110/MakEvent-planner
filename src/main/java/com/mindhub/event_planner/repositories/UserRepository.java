package com.mindhub.event_planner.repositories;

import com.mindhub.event_planner.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

    UserEntity findById (long id);

    UserEntity findByEmail(String email);

    boolean existsByEmail (String email);
}
