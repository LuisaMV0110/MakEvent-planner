package com.mindhub.event_planner.repositories;

import com.mindhub.event_planner.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Comment findById (long id);
}
