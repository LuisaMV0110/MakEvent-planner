package com.mindhub.event_planner.services;

import java.util.List;

public interface GenericService <Entity, DTO>{
    List<DTO> findAll();
}
