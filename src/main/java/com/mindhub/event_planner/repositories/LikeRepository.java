package com.mindhub.event_planner.repositories;

import com.mindhub.event_planner.models.LikeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<LikeStatus, Long> {

    LikeStatus findById (long id);

}
