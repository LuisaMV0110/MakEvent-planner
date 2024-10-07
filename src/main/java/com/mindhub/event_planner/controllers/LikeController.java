package com.mindhub.event_planner.controllers;

import com.mindhub.event_planner.dtos.CommentDTOA;
import com.mindhub.event_planner.dtos.LikeDTOA;
import com.mindhub.event_planner.dtos.notAccesibleForEveryone.CommentDTONA;
import com.mindhub.event_planner.dtos.notAccesibleForEveryone.LikeDTONA;
import com.mindhub.event_planner.models.*;
import com.mindhub.event_planner.services.CustomerService;
import com.mindhub.event_planner.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/like")
public class LikeController {

    @Autowired
    LikeService likeService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/auth/all")
    public List<?> getAll(Authentication authentication){
        Customer customer = customerService.findByEmail(authentication.getName());
        List<LikeDTONA> likes = likeService.findAll();
        if(customer instanceof UserEntity){
            return ((UserEntity) customer).getLikeS().stream().map(LikeDTOA::new).collect(Collectors.toList());
        } else if (customer instanceof Manager){
            return likes.stream().filter(like -> like.getEvent().getManager().getEmail().equals(customer.getEmail())).collect(Collectors.toList());
        }
        return likes;
    }

    @GetMapping("/auth/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id, Authentication authentication){
        Customer customer = customerService.findByEmail(authentication.getName());
        LikeStatus likeS = likeService.findById(id);
        if ((likeS != null && likeS.getEvent().getManager() == customer) || customer instanceof Admin){
            return new ResponseEntity<>(new LikeDTONA(likeService.findById(id)), HttpStatus.OK);
        } else if (likeS != null && likeS.getEvent().getManager() != customer){
            return new ResponseEntity<>(new LikeDTOA(likeService.findById(id)), HttpStatus.OK);
        }
        return new ResponseEntity<>("An error occurred finding the like with ID: " + id, HttpStatus.FORBIDDEN);
    }

    @GetMapping("/public/all")
    public List<LikeDTOA> getAll2(){
        return likeService.findAll2();
    }

    @GetMapping("/public/{id}")
    public ResponseEntity<?> getById2(@PathVariable Long id){
        return new ResponseEntity<>(new LikeDTOA(likeService.findById(id)), HttpStatus.OK);
    }
}
