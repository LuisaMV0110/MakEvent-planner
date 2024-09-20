package com.mindhub.event_planner.controllers;

import com.mindhub.event_planner.dtos.LikeDTO;
import com.mindhub.event_planner.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/like")
public class LikeController {

    @Autowired
    LikeService likeService;

    @GetMapping("/all")
    public List<LikeDTO> getAll(){
        return likeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(new LikeDTO(likeService.findById(id)), HttpStatus.OK);
    }
}
